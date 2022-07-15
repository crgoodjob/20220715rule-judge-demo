package cn.maitian.bss.modules.system.service;

import cn.maitian.bss.modules.system.controller.request.RoleHandleRequest;
import cn.maitian.bss.modules.system.controller.request.RoleQueryRequest;
import cn.maitian.bss.modules.system.controller.request.UserAssignRequest;
import cn.maitian.bss.modules.system.controller.response.TreeCheckResponse;
import cn.maitian.bss.modules.system.controller.response.UserRoleCheckResponse;
import cn.maitian.bss.modules.system.model.SysRole;
import cn.maitian.bss.modules.system.model.SysUser;
import cn.maitian.bss.modules.system.vo.SysRoleVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
public interface SysRoleIService extends IService<SysRole> {

    /**
     * 分页查询
     *
     * @param roleQueryRequest
     * @return
     */
    IPage<SysRoleVO> selectPage(RoleQueryRequest roleQueryRequest);

    /**
     * 通过用户Id获取用户角色
     *
     * @param userId
     * @return
     */
    UserRoleCheckResponse getRoleListByUserId(String userId);

    /**
     * 对用户进行角色授权
     *
     * @param userAssignRequest
     */
    void assignRole(UserAssignRequest userAssignRequest);

    /**
     * 通过角色ID获取菜单树
     *
     * @param roleId
     * @return
     */
    TreeCheckResponse getMenuTreeByRoleId(String roleId);

    /**
     * 通过角色ID获取职位树
     *
     * @param roleId
     * @return
     */
    TreeCheckResponse getPostTreeByRoleId(String roleId);

    /**
     * 创建角色
     *
     * @param roleHandleRequest
     */
    void insertRole(RoleHandleRequest roleHandleRequest);

    /**
     * 更新角色
     *
     * @param roleHandleRequest
     */
    void updateRole(RoleHandleRequest roleHandleRequest);

    /**
     * 删除角色
     *
     * @param roleId
     */
    void deleteRoleById(String roleId);

    /**
     * 通过角色ID查询角色编码或角色名称
     *
     * @param roleName
     * @param roleCode
     * @param roleId
     * @return
     */
    Long countByRoleNameOrRoleCodeEqId(String roleName, String roleCode, String roleId);

    /**
     * 获取用户权限
     *
     * @param user
     * @return
     */
    String getUserAuth(SysUser user);

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     */
    Map<String, Object> getUserAuth(String userId);

}
