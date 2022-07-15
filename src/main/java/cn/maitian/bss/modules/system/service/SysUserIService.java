package cn.maitian.bss.modules.system.service;

import cn.maitian.bss.modules.system.controller.request.UserQueryRequest;
import cn.maitian.bss.modules.system.model.SysUser;
import cn.maitian.bss.modules.system.vo.SysUserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
public interface SysUserIService extends IService<SysUser> {

    /**
     * 分页查询
     *
     * @param userQueryRequest
     * @return
     */
    IPage<SysUserVO> selectPage(UserQueryRequest userQueryRequest);

    /**
     * 通过登陆名获取用户
     *
     * @param userLoginName
     * @return
     */
    SysUser getByUserLoginName(String userLoginName);

    /**
     * 获取用户权限
     *
     * @param user
     * @return
     */
    String getUserAuth(SysUser user);


    /**
     * 通过旧用户ID获取用户值对象
     *
     * @param oldUserId
     * @return
     */
    SysUserVO getUserVoByOldUserId(Integer oldUserId);

    /**
     * 通过旧用户ID获取用户对象
     *
     * @param oldUserId
     * @return
     */
    SysUser getUserByOldUserId(Integer oldUserId);

}
