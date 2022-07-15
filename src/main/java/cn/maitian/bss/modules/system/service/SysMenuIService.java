package cn.maitian.bss.modules.system.service;

import cn.maitian.bss.modules.system.controller.request.MenuRequest;
import cn.maitian.bss.modules.system.controller.request.MenuSortRequest;
import cn.maitian.bss.modules.system.model.SysMenu;
import cn.maitian.bss.modules.system.vo.SysMenuVO;
import cn.maitian.bss.modules.system.vo.TreeVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
public interface SysMenuIService extends IService<SysMenu> {

    /**
     * 菜单列表
     *
     * @return
     */
    List<SysMenuVO> menuList();

    /**
     * 菜单树
     *
     * @return
     */
    List<TreeVO> menuTreeList();

    /**
     * 菜单排序
     *
     * @param menuSortRequestList
     */
    void sortMenu(List<MenuSortRequest> menuSortRequestList);

    /**
     * 保存菜单
     *
     * @param menuRequest
     */
    void saveMenu(MenuRequest menuRequest);

    /**
     * 更新菜单
     *
     * @param menuRequest
     */
    void updateMenu(MenuRequest menuRequest);

    /**
     * 删除菜单
     *
     * @param id
     */
    void deleteMenuById(String id);

    /**
     * 菜单名称总数
     *
     * @param id
     * @param parentId
     * @param menuName
     * @return
     */
    Long countByMenuName(String id, String parentId, String menuName);

}
