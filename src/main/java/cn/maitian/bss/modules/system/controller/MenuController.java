package cn.maitian.bss.modules.system.controller;

import cn.maitian.bss.modules.common.web.Result;
import cn.maitian.bss.modules.common.web.ResultCode;
import cn.maitian.bss.modules.common.web.response.ResponseResult;
import cn.maitian.bss.modules.system.controller.request.MenuRequest;
import cn.maitian.bss.modules.system.controller.request.MenuSortRequest;
import cn.maitian.bss.modules.system.service.SysMenuIService;
import cn.maitian.bss.modules.system.vo.SysMenuVO;
import cn.maitian.bss.modules.system.vo.TreeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单控制器
 * </p>
 *
 * @author liguo
 * @since 2021-08-13
 */
@Slf4j
@ResponseResult
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private SysMenuIService sysMenuIService;

    @GetMapping("/list")
    public List<SysMenuVO> menuList() {
        return sysMenuIService.menuList();
    }

    @GetMapping("/tree")
    public List<TreeVO> menuTreeList() {
        return sysMenuIService.menuTreeList();
    }

    @PostMapping("/save")
    public Result saveMenu(@RequestBody MenuRequest menuRequest) {
        sysMenuIService.saveMenu(menuRequest);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateMenu(@RequestBody MenuRequest menuRequest) {
        sysMenuIService.updateMenu(menuRequest);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result deleteMenu(@RequestBody MenuRequest menuRequest) {
        sysMenuIService.deleteMenuById(menuRequest.getId());
        return Result.success();
    }

    @PostMapping(value = "/sort")
    public Result sortMenu(@RequestBody List<MenuSortRequest> menuSortRequestList) {
        sysMenuIService.sortMenu(menuSortRequestList);
        return Result.success();
    }

    @PostMapping(value = "/validateMenuName")
    public Result validateMenuName(MenuRequest menuRequest){
        Long count = sysMenuIService.countByMenuName(menuRequest.getId(), menuRequest.getParentId(), menuRequest.getMenuName());
        if (count > 0) {
            return Result.success(ResultCode.SUCCESS_CHECK, Result.failure(ResultCode.MENU_SUB_NAME_EXIST));
        }
        return Result.success(ResultCode.SUCCESS_CHECK);
    }
}
