package cn.maitian.bss.modules.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.maitian.bss.modules.common.web.ResultCode;
import cn.maitian.bss.modules.common.web.exception.BusinessException;
import cn.maitian.bss.modules.common.web.exception.ParameterException;
import cn.maitian.bss.modules.system.controller.request.RoleHandleRequest;
import cn.maitian.bss.modules.system.controller.request.RoleQueryRequest;
import cn.maitian.bss.modules.system.controller.request.UserAssignRequest;
import cn.maitian.bss.modules.system.controller.response.TreeCheckResponse;
import cn.maitian.bss.modules.system.controller.response.UserRoleCheckResponse;
import cn.maitian.bss.modules.system.dao.SysMenuMapper;
import cn.maitian.bss.modules.system.dao.SysRoleMapper;
import cn.maitian.bss.modules.system.model.SysMenu;
import cn.maitian.bss.modules.system.model.SysRole;
import cn.maitian.bss.modules.system.model.SysUser;
import cn.maitian.bss.modules.system.service.SysMenuIService;
import cn.maitian.bss.modules.system.service.SysPostIService;
import cn.maitian.bss.modules.system.service.SysRoleIService;
import cn.maitian.bss.modules.system.service.SysUserIService;
import cn.maitian.bss.modules.system.vo.SysRoleVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleIService {

    @Autowired
    private SysUserIService sysUserIService;

    @Autowired
    private SysMenuIService sysMenuIService;

    @Autowired
    private SysPostIService sysPostIService;

    @Autowired
    private SysMenuMapper sysMenuMapper;


    /**
     * 分页查询
     *
     * @param roleQueryRequest
     * @return
     */
    @Override
    public IPage<SysRoleVO> selectPage(RoleQueryRequest roleQueryRequest) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(roleQueryRequest.getRoleName())) {
            wrapper.like("role_name", roleQueryRequest.getRoleName());
        }

        IPage<SysRole> page = getBaseMapper().selectPage(new Page<>(roleQueryRequest.getPageNo(), roleQueryRequest.getPageSize()), wrapper);

        List<SysRoleVO> roleList = new ArrayList<>();
        page.getRecords().stream().forEach(role -> {
            SysRoleVO vo = new SysRoleVO();
            BeanUtil.copyProperties(role, vo);
            roleList.add(vo);
        });

        IPage<SysRoleVO> p = new Page<>();
        p.setTotal(page.getTotal());
        p.setRecords(roleList);

        return p;
    }

    /**
     * 通过用户Id获取用户角色
     *
     * @param userId
     * @return
     */
    @Override
    public UserRoleCheckResponse getRoleListByUserId(String userId) {
        UserRoleCheckResponse response = new UserRoleCheckResponse();
        response.setRoleList(getAllAvailableRoleList());
        response.setDefaultCheckedList(getBaseMapper().getRoleIdsByUserId(userId));
        return response;
    }

    /**
     * 对用户进行角色授权
     *
     * @param userAssignRequest
     */
    @Override
    @Transactional
    public void assignRole(UserAssignRequest userAssignRequest) {
        String userId = userAssignRequest.getUserId();
        SysUser sysUser = sysUserIService.getById(userId);
        if (sysUser == null) {
            throw new BusinessException(ResultCode.USER_NOT_FOUND.getMessage());
        }

        // 删除关系表
        getBaseMapper().deleteRoleUserRelationByUserId(userId);

        // 保存用户角色关系
        String[] roleIds = userAssignRequest.getRoleIds();
        for (String roleId : roleIds) {
            getBaseMapper().saveRoleUserRelation(userId, roleId);
        }

    }

    /**
     * 通过角色ID获取菜单树
     *
     * @param roleId
     * @return
     */
    @Override
    public TreeCheckResponse getMenuTreeByRoleId(String roleId) {
        TreeCheckResponse response = new TreeCheckResponse();
        response.setTreeList(sysMenuIService.menuTreeList());
        response.setDefaultCheckedList(getBaseMapper().getMenuIdsByRoleId(roleId));
        return response;
    }

    /**
     * 通过角色ID获取职位树
     *
     * @param roleId
     * @return
     */
    @Override
    public TreeCheckResponse getPostTreeByRoleId(String roleId) {
        TreeCheckResponse response = new TreeCheckResponse();
        response.setTreeList(sysPostIService.postTreeList());
        response.setDefaultCheckedList(getBaseMapper().getPostIdsByRoleId(roleId));
        return response;
    }

    /**
     * 创建角色
     *
     * @param roleHandleRequest
     */
    @Transactional
    @Override
    public void insertRole(RoleHandleRequest roleHandleRequest) {
        saveOrUpdateRole(roleHandleRequest);
    }

    /**
     * 更新角色
     *
     * @param roleHandleRequest
     */
    @Transactional
    @Override
    public void updateRole(RoleHandleRequest roleHandleRequest) {
        saveOrUpdateRole(roleHandleRequest);
    }

    /**
     * 删除角色
     *
     * @param roleId
     */
    @Transactional
    @Override
    public void deleteRoleById(String roleId) {
        SysRoleMapper roleMapper = getBaseMapper();
        roleMapper.deleteRoleMenuRelationByRoleId(roleId);
        roleMapper.deleteRolePostRelationByRoleId(roleId);
        roleMapper.deleteRoleUserRelationByRoleId(roleId);
        roleMapper.deleteById(roleId);
    }

    /**
     * 获取可用的角色列表
     *
     * @return
     */
    private List<SysRoleVO> getAllAvailableRoleList() {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("is_available", "1");
        List<SysRole> roleList = getBaseMapper().selectList(wrapper);

        List<SysRoleVO> roleVoList = new ArrayList<>();
        roleList.stream().forEach(role -> {
            SysRoleVO vo = new SysRoleVO();
            BeanUtil.copyProperties(role, vo);
            roleVoList.add(vo);
        });

        return roleVoList;
    }

    /**
     * 保存或更新角色
     *
     * @param roleHandleRequest
     */
    private void saveOrUpdateRole(RoleHandleRequest roleHandleRequest) {
        String roleCode = roleHandleRequest.getRoleCode();
        String roleName = roleHandleRequest.getRoleName();
        String roleId = roleHandleRequest.getId();
        SysRoleMapper roleMapper = getBaseMapper();

        // 校验表单
        validateForm(roleCode, roleName);
        SysRole role = new SysRole();
        if (StringUtils.isNotBlank(roleId)) {
            role = getById(roleId);
        }

        if (role == null) {
            throw new ParameterException(ResultCode.ROLE_NOT_FOUND.getMessage());
        }

        Long roleNameCount = countByRoleNameOrRoleCodeEqId(roleName, null, roleId);
        if (roleNameCount > 0) {
            throw new ParameterException(ResultCode.ROLE_NAME_EXIST.getMessage());
        }

        Long roleCodeCount = countByRoleNameOrRoleCodeEqId(null, roleCode, roleId);
        if (roleCodeCount > 0) {
            throw new ParameterException(ResultCode.ROLE_CODE_EXIST.getMessage());
        }

        role.setRoleCode(roleCode);
        role.setRoleName(roleName);
        role.setRemark(roleHandleRequest.getRemark());
        role.setIsAvailable(roleHandleRequest.getIsAvailable());

        // SysUserVO currentUser = SecurityUtils.getSecurityUserInfo();
        // String userLoginName = currentUser.getUserLoginName();
        String userLoginName = "";
        role.setUpdateUser(userLoginName);
        //role.setUpdateTime(new Date());

        // 保存或更新角色
        saveOrUpdate(role);

        // 角色主键
        String rId = role.getId();

        // 删除关系表
        if (StringUtils.isNotBlank(rId)) {
            roleMapper.deleteRoleMenuRelationByRoleId(rId);
            roleMapper.deleteRolePostRelationByRoleId(rId);
        }

        // 处理菜单数据
        List<String> menuIds = roleHandleRequest.getMenuIds();
        if (null != menuIds && 0 < menuIds.size()) {
            menuIds.stream().forEach(menuId -> {
                roleMapper.saveRoleMenuRelation(menuId, rId);
            });
        }

        // 处理职位数据
        List<String> positionIds = roleHandleRequest.getPositionIds();
        if (null != positionIds && 0 < positionIds.size()) {
            positionIds.stream().forEach(positionId -> {
                roleMapper.saveRolePostRelation(positionId, rId);
            });
        }
    }

    /**
     * 校验角色编码和角色名称
     *
     * @param roleCode
     * @param roleName
     */
    private void validateForm(String roleCode, String roleName) {
        if (StringUtils.isBlank(roleCode) || StringUtils.isBlank(roleName)) {
            throw new BusinessException(ResultCode.INVALID_ARGUMENT.getMessage());
        }
    }

    /**
     * 通过角色ID查询角色编码或角色名称
     *
     * @param roleName
     * @param roleCode
     * @param roleId
     * @return
     */
    @Override
    public Long countByRoleNameOrRoleCodeEqId(String roleName, String roleCode, String roleId) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(roleId)) {
            wrapper.ne("id", roleId);
        }

        if (StringUtils.isNotBlank(roleName)) {
            wrapper.eq("role_name", roleName);
        }

        if (StringUtils.isNotBlank(roleCode)) {
            wrapper.eq("role_code", roleCode);
        }

        return getBaseMapper().selectCount(wrapper);
    }

    /**
     * 获取用户权限
     *
     * @param user
     * @return
     */
    @Override
    public String getUserAuth(SysUser user) {
        String rolePrefix = "ROLE_";
        List<String> authorityList = new ArrayList<>();
        List<String> roleIdList = getBaseMapper().getRoleIds(user.getId(), user.getPostId());
        if (roleIdList != null && roleIdList.size() > 0) {
            List<SysMenu> menuList = sysMenuMapper.getMenuListByRoleIdList(roleIdList);
            List<SysRole> roleList = getBaseMapper().selectBatchIds(roleIdList);

            menuList.stream().filter(menu -> StringUtils.isNotBlank(menu.getAuthorityCode())).forEach(menu -> {
                authorityList.add(menu.getAuthorityCode());
            });

            roleList.stream().filter(role -> "1".equals(role.getIsAvailable())).forEach(role -> {
                authorityList.add(rolePrefix + role.getRoleCode());
            });
        }

        return StringUtils.join(authorityList, ",");
    }

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> getUserAuth(String userId) {
        SysUser user = sysUserIService.getById(userId);
        List<String> roleIdList = getBaseMapper().getRoleIds(user.getId(), user.getPostId());
        List<SysMenu> menuList = sysMenuMapper.getMenuListByRoleIdList(roleIdList);
        List<SysRole> roleList = getBaseMapper().selectBatchIds(roleIdList);
        List<String> authorityList = new ArrayList<>();
        List<String> roleCodeList = new ArrayList<>();

        menuList.stream().filter(menu -> StringUtils.isNotBlank(menu.getAuthorityCode())).forEach(menu -> {
            authorityList.add(menu.getAuthorityCode());
        });

        roleList.stream().filter(role -> "1".equals(role.getIsAvailable())).forEach(role -> {
            // authorityList.add(role.getRoleCode());
            roleCodeList.add(role.getRoleCode());
        });

        Map<String, Object> result = new HashMap<>();
        result.put("menuList", menuList);
        result.put("roleList", roleCodeList);
        result.put("authorityList", authorityList);
        return result;
    }
}
