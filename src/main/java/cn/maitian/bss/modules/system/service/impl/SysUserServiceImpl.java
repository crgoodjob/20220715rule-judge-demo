package cn.maitian.bss.modules.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.maitian.bss.modules.system.controller.request.UserQueryRequest;
import cn.maitian.bss.modules.system.dao.SysDeptMapper;
import cn.maitian.bss.modules.system.dao.SysPostMapper;
import cn.maitian.bss.modules.system.dao.SysUserMapper;
import cn.maitian.bss.modules.system.model.SysDept;
import cn.maitian.bss.modules.system.model.SysPost;
import cn.maitian.bss.modules.system.model.SysUser;
import cn.maitian.bss.modules.system.service.SysRoleIService;
import cn.maitian.bss.modules.system.service.SysUserIService;
import cn.maitian.bss.modules.system.vo.SysUserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserIService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysPostMapper sysPostMapper;

    @Autowired
    private SysRoleIService sysRoleIService;

    /**
     * 分页查询
     *
     * @param userQueryRequest
     * @return
     */
    @Override
    public IPage<SysUserVO> selectPage(UserQueryRequest userQueryRequest) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(userQueryRequest.getUserName())) {
            wrapper.like("user_name", userQueryRequest.getUserName());
        }

        if (StringUtils.isNotBlank(userQueryRequest.getUserLoginName())) {
            wrapper.eq("user_login_name", userQueryRequest.getUserLoginName());
        }

        if (StringUtils.isNotBlank(userQueryRequest.getDeptId())) {
            wrapper.eq("dept_id", userQueryRequest.getDeptId());
        }

        if (StringUtils.isNotBlank(userQueryRequest.getPostId())) {
            wrapper.eq("post_id", userQueryRequest.getPostId());
        }

        IPage<SysUser> page = getBaseMapper().selectPage(new Page<>(userQueryRequest.getPageNo(), userQueryRequest.getPageSize()), wrapper);

        List<SysUserVO> userList = new ArrayList<>();
        page.getRecords().stream().forEach(user -> {
            SysUserVO userVO = new SysUserVO();
            BeanUtil.copyProperties(user, userVO);

            SysDept dept = sysDeptMapper.selectById(userVO.getDeptId());
            if (dept != null) {
                userVO.setDeptName(dept.getDeptName());
            }

            SysPost post = sysPostMapper.selectById(userVO.getPostId());
            if (post != null) {
                userVO.setPostName(post.getPostName());
            }

            userList.add(userVO);
        });

        IPage<SysUserVO> p = new Page<>();
        p.setTotal(page.getTotal());
        p.setRecords(userList);

        return p;
    }

    /**
     * 通过登陆名获取用户
     *
     * @param userLoginName
     * @return
     */
    @Override
    public SysUser getByUserLoginName(String userLoginName) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_login_name", userLoginName).eq("status", "1");
        return getBaseMapper().selectOne(wrapper);
    }

    /**
     * 获取用户权限
     *
     * @param user
     * @return
     */
    @Override
    public String getUserAuth(SysUser user) {
        return sysRoleIService.getUserAuth(user);
    }

    /**
     * @param oldUserId
     * @return
     */
    @Override
    public SysUser getUserByOldUserId(Integer oldUserId) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("old_user_id", oldUserId).eq("status", "1");
        return getBaseMapper().selectOne(wrapper);
    }

    /**
     * @param oldUserId
     * @return
     */
    @Override
    public SysUserVO getUserVoByOldUserId(Integer oldUserId) {
        SysUser user = getUserByOldUserId(oldUserId);
        SysUserVO userVO = new SysUserVO();
        BeanUtil.copyProperties(user, userVO);

        // 补充职位名称
        SysPost post = sysPostMapper.selectById(user.getPostId());
        if (post != null) {
            userVO.setPostName(post.getPostName());
        }

        return userVO;
    }
}
