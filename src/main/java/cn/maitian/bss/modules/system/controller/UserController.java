package cn.maitian.bss.modules.system.controller;

import cn.maitian.bss.modules.common.web.PageResult;
import cn.maitian.bss.modules.common.web.Result;
import cn.maitian.bss.modules.common.web.ResultCode;
import cn.maitian.bss.modules.common.web.response.ResponseResult;
import cn.maitian.bss.modules.security.JwtTokenVO;
import cn.maitian.bss.modules.security.JwtUser;
import cn.maitian.bss.modules.security.JwtUtil;
import cn.maitian.bss.modules.security.SecurityUtils;
import cn.maitian.bss.modules.system.controller.request.UserAssignRequest;
import cn.maitian.bss.modules.system.controller.request.UserQueryRequest;
import cn.maitian.bss.modules.system.model.SysUser;
import cn.maitian.bss.modules.system.service.SysRoleIService;
import cn.maitian.bss.modules.system.service.SysUserIService;
import cn.maitian.bss.modules.system.vo.SysRoleVO;
import cn.maitian.bss.modules.system.controller.response.UserRoleCheckResponse;
import cn.maitian.bss.modules.system.vo.SysUserVO;
import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户控制器
 * </p>
 *
 * @author liguo
 * @since 2021-08-13
 */
@Slf4j
@ResponseResult
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private SysUserIService sysUserIService;

    @Autowired
    private SysRoleIService sysRoleIService;

    /**
     * 分页列表
     *
     * @param userQueryRequest
     * @return
     */
    @GetMapping("/list")
    public PageResult getPageUser(UserQueryRequest userQueryRequest) {
        IPage<SysUserVO> page = sysUserIService.selectPage(userQueryRequest);
        return new PageResult(page.getRecords(), page.getTotal());
    }

    /**
     * 通过用户ID获取拥有的角色
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/userRoleList")
    @FastJsonView(include = {@FastJsonFilter(clazz = SysRoleVO.class, props = {"id", "roleName"})})
    public Result userRoleList(String userId) {
        UserRoleCheckResponse userRoleCheckVO = sysRoleIService.getRoleListByUserId(userId);
        return Result.success(userRoleCheckVO);
    }

    /**
     * 角色授权
     *
     * @param userAssignRequest
     * @return
     */
    @PostMapping(value = "/assignRole")
    public Result assignRole(@RequestBody UserAssignRequest userAssignRequest) {
        sysRoleIService.assignRole(userAssignRequest);
        return Result.success();
    }

    /**
     * 查询当前用户权限信息
     *
     * @return
     */
    @GetMapping(value = "/auth")
    public Result userAuthority() {
        return Result.success(ResultCode.SUCCESS, sysRoleIService.getUserAuth(SecurityUtils.getUserId()));
    }

    /**
     * 移动端快捷登陆
     *
     * @param oldUserId
     * @param password
     * @return
     */
    @ApiOperation(value = "移动端快捷登陆", notes = "移动端快捷登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldUserId", value = "旧用户ID", required = true, dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "password", value = "密码（加密的）", required = true, dataTypeClass = String.class),
    })
    @PostMapping(value = "/mobile/login")
    public Map<String, Object> login(Integer oldUserId, String password) {
        Map<String, Object> result = new HashMap<>();
        if (oldUserId == null || StringUtils.isBlank(password)) {
            result.put("code", ResultCode.LOGIN_FAILURE.getCode());
            result.put("msg", ResultCode.LOGIN_FAILURE.getMessage());
            return result;
        }

        SysUserVO user = sysUserIService.getUserVoByOldUserId(oldUserId);
        if (user == null || !user.getPassword().equals(password)) {
            result.put("code", ResultCode.LOGIN_FAILURE.getCode());
            result.put("msg", ResultCode.LOGIN_FAILURE.getMessage());
            return result;
        }

        JwtTokenVO jwtTokenVO = JwtUtil.getJwtToken(user.getUserLoginName(), user.getUserName(), user.getId());
        result.put("code", ResultCode.SUCCESS.getCode());
        result.put("msg", ResultCode.SUCCESS.getMessage());
        result.put("data", user);
        result.put("jwtTokenVO", jwtTokenVO);
        return result;
    }

    @ApiOperation(value = "快捷登陆", notes = "快捷登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userLoginName", value = "登陆名", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码（加密的）", required = true, dataTypeClass = String.class)
    })
    @PostMapping(value = "/doLogin")
    public Result doLogin(String userLoginName, String password) {
        log.info("快捷登陆 ==> userLoginName:{},password:{}", userLoginName, password);
        SysUser user = sysUserIService.getByUserLoginName(userLoginName);
        if (user == null || !user.getPassword().equals(password)) {
            return Result.failure(ResultCode.LOGIN_FAILURE);
        }

        JwtTokenVO jwtTokenVO = JwtUtil.getJwtToken(user.getUserLoginName(), user.getUserName(), user.getId());
        return Result.success(jwtTokenVO);
    }

}
