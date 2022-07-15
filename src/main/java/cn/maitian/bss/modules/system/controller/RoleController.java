package cn.maitian.bss.modules.system.controller;

import cn.maitian.bss.modules.common.web.PageResult;
import cn.maitian.bss.modules.common.web.Result;
import cn.maitian.bss.modules.common.web.ResultCode;
import cn.maitian.bss.modules.common.web.response.ResponseResult;
import cn.maitian.bss.modules.system.controller.request.RoleHandleRequest;
import cn.maitian.bss.modules.system.controller.request.RoleQueryRequest;
import cn.maitian.bss.modules.system.service.SysRoleIService;
import cn.maitian.bss.modules.system.vo.SysRoleVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色控制器
 * </p>
 *
 * @author liguo
 * @since 2021-08-13
 */
@Slf4j
@ResponseResult
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private SysRoleIService sysRoleIService;

    /**
     * 分页列表
     *
     * @param roleQueryRequest
     * @return
     */
    @GetMapping("/list")
    public PageResult getPageRole(RoleQueryRequest roleQueryRequest) {
        IPage<SysRoleVO> page = sysRoleIService.selectPage(roleQueryRequest);
        return new PageResult(page.getRecords(), page.getTotal());
    }

    /**
     * 增加角色
     *
     * @param roleHandleRequest
     * @return
     */
    @PostMapping("/add")
    public Result addRole(@RequestBody RoleHandleRequest roleHandleRequest) {
        sysRoleIService.insertRole(roleHandleRequest);
        return Result.success();
    }

    /**
     * 修改角色
     *
     * @param roleHandleRequest
     * @return
     */
    @PutMapping("/edit")
    public Result editRole(@RequestBody RoleHandleRequest roleHandleRequest) {
        sysRoleIService.updateRole(roleHandleRequest);
        return Result.success();
    }

    /**
     * 删除角色
     *
     * @param roleHandleRequest
     * @return
     */
    @DeleteMapping("/delete")
    public Result deleteRole(@RequestBody RoleHandleRequest roleHandleRequest) {
        sysRoleIService.deleteRoleById(roleHandleRequest.getId());
        return Result.success();
    }

    /**
     * 获取菜单的树形结构
     *
     * @param roleId
     * @return
     */
    @GetMapping(value = "/getMenuTreeByRoleId")
    public Result getMenuTreeByRoleId(String roleId) {
        return Result.success(sysRoleIService.getMenuTreeByRoleId(roleId));
    }

    /**
     * 获取职位的树形结构
     *
     * @param roleId
     * @return
     */
    @GetMapping(value = "/getPositionTreeByRoleId")
    public Result getPositionTreeByRoleId(String roleId) {
        return Result.success(sysRoleIService.getPostTreeByRoleId(roleId));
    }

    /**
     * 创建角色时 验证角色名称是否重复
     *
     * @param roleHandleRequest
     * @return
     */
    @GetMapping(value = "/validateAddRoleName")
    public Result validateAddRoleName(RoleHandleRequest roleHandleRequest) {
        Long count = sysRoleIService.countByRoleNameOrRoleCodeEqId(roleHandleRequest.getRoleName(), null, roleHandleRequest.getId());
        if (count > 0) {
            return Result.success(ResultCode.SUCCESS_CHECK, Result.failure(ResultCode.ROLE_NAME_EXIST));
        }
        return Result.success(ResultCode.SUCCESS_CHECK);
    }

    /**
     * 创建角色时 验证角色值是否重复
     *
     * @param roleHandleRequest
     * @return
     */
    @GetMapping(value = "/validateAddRoleCode")
    public Result validateAddRoleCode(RoleHandleRequest roleHandleRequest) {
        Long count = sysRoleIService.countByRoleNameOrRoleCodeEqId(null, roleHandleRequest.getRoleCode(), roleHandleRequest.getId());
        if (count > 0) {
            return Result.success(ResultCode.SUCCESS_CHECK, Result.failure(ResultCode.ROLE_CODE_EXIST));
        }
        return Result.success(ResultCode.SUCCESS_CHECK);
    }

    /**
     * 修改角色时 验证角色名称是否重复
     *
     * @param roleHandleRequest
     * @return
     */
    @GetMapping(value = "/validateEditRoleName")
    public Result validateEditRoleName(RoleHandleRequest roleHandleRequest) {
        Long count = sysRoleIService.countByRoleNameOrRoleCodeEqId(roleHandleRequest.getRoleName(), null, roleHandleRequest.getId());
        if (count > 0) {
            return Result.success(ResultCode.SUCCESS_CHECK, Result.failure(ResultCode.ROLE_NAME_EXIST));
        }
        return Result.success(ResultCode.SUCCESS_CHECK);
    }

    /**
     * 修改角色时 验证角色值是否重复
     *
     * @param roleHandleRequest
     * @return
     */
    @GetMapping(value = "/validateEditRoleCode")
    public Result validateEditRoleCode(RoleHandleRequest roleHandleRequest) {
        Long count = sysRoleIService.countByRoleNameOrRoleCodeEqId(null, roleHandleRequest.getRoleCode(), roleHandleRequest.getId());
        if (count > 0) {
            return Result.success(ResultCode.SUCCESS_CHECK, Result.failure(ResultCode.ROLE_CODE_EXIST));
        }
        return Result.success(ResultCode.SUCCESS_CHECK);
    }

}
