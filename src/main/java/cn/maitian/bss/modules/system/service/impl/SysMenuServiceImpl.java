package cn.maitian.bss.modules.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.maitian.bss.modules.system.controller.request.MenuRequest;
import cn.maitian.bss.modules.system.controller.request.MenuSortRequest;
import cn.maitian.bss.modules.system.dao.SysMenuMapper;
import cn.maitian.bss.modules.system.model.SysMenu;
import cn.maitian.bss.modules.system.service.SysMenuIService;
import cn.maitian.bss.modules.system.utils.TreeUtils;
import cn.maitian.bss.modules.system.vo.SysMenuVO;
import cn.maitian.bss.modules.system.vo.TreeVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuIService {

    /**
     * 菜单列表
     *
     * @return
     */
    @Override
    public List<SysMenuVO> menuList() {
        List<SysMenuVO> menuList = Lists.newArrayList();
        List<SysMenuVO> sourceList = getBaseMapper().getMenuList();
        this.sortList(menuList, sourceList, TreeUtils.ROOT_ID);
        return menuList;
    }

    /**
     * 菜单树
     *
     * @return
     */
    @Override
    public List<TreeVO> menuTreeList() {
        List<TreeVO> treeList = Lists.newArrayList();
        List<TreeVO> sourceList = getBaseMapper().getMenuTreeList();
        TreeUtils.sortTree(treeList, sourceList, TreeUtils.ROOT_ID);
        return treeList;
    }

    /**
     * 菜单排序
     *
     * @param menuSortRequestList
     */
    @Override
    public void sortMenu(List<MenuSortRequest> menuSortRequestList) {
        List<SysMenu> menuList = Lists.newArrayList();
        for (MenuSortRequest menuSortRequest : menuSortRequestList) {
            SysMenu menu = new SysMenu();
            menu.setId(menuSortRequest.getId());
            menu.setSeq(menuSortRequest.getSeq());
            menuList.add(menu);
        }
        updateBatchById(menuList);
    }

    /**
     * 保存菜单
     *
     * @param menuRequest
     */
    @Override
    public void saveMenu(MenuRequest menuRequest) {
        saveOrUpdateMenu(menuRequest);
    }

    /**
     * 更新菜单
     *
     * @param menuRequest
     */
    @Override
    public void updateMenu(MenuRequest menuRequest) {
        saveOrUpdateMenu(menuRequest);
    }

    /**
     * 删除菜单
     *
     * @param id
     */
    @Override
    public void deleteMenuById(String id) {
        doDeleteMenu(id);
    }

    /**
     * 菜单名称总数
     *
     * @param id
     * @param parentId
     * @param menuName
     * @return
     */
    @Override
    public Long countByMenuName(String id, String parentId, String menuName) {
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(id)) {
            wrapper.ne("id", id);
        }

        if (StringUtils.isBlank(parentId)) {
            parentId = TreeUtils.ROOT_ID;
        }

        if (StringUtils.isNotBlank(parentId)) {
            wrapper.eq("parent_id", parentId);
        }

        if (StringUtils.isNotBlank(menuName)) {
            wrapper.eq("menu_name", menuName);
        }

        return getBaseMapper().selectCount(wrapper);
    }

    /**
     * 保存或更新菜单
     *
     * @param menuRequest
     */
    private void saveOrUpdateMenu(MenuRequest menuRequest) {
        if (StringUtils.isBlank(menuRequest.getParentId())) {
            menuRequest.setParentId(TreeUtils.ROOT_ID);
        }

        SysMenu menu = new SysMenu();
        BeanUtil.copyProperties(menuRequest, menu);
        saveOrUpdate(menu);
    }

    /**
     * 通过菜单ID级联删除
     *
     * @param id
     */
    private void doDeleteMenu(String id) {
        List<SysMenuVO> menus = getBaseMapper().getMenuListByParentId(id);

        for (SysMenuVO menu : menus) {
            doDeleteMenu(menu.getId());
        }

        removeById(id);
    }

    /**
     * 递归菜单树
     *
     * @param list
     * @param sourceList
     * @param parentId
     */
    private void sortList(List<SysMenuVO> list, List<SysMenuVO> sourceList, String parentId) {
        for (int i = 0; i < sourceList.size(); i++) {
            SysMenuVO e = sourceList.get(i);
            e.setId(e.getId().trim());
            if ((e.getParentId() != null && (e.getParentId().trim()).equals(parentId)) || ((e.getParentId() == null || "".equals(e.getParentId())) && TreeUtils.ROOT_ID.equals(parentId))) {
                list.add(e);
                // 判断是否还有子节点, 有则继续获取子节点
                for (int j = 0; j < sourceList.size(); j++) {
                    SysMenuVO child = sourceList.get(j);
                    child.setId(child.getId().trim());
                    if (child.getParentId() != null && child.getParentId().equals(e.getId())) {
                        e.setChildren(new ArrayList<>());
                        sortList(e.getChildren(), sourceList, e.getId());
                        break;
                    }
                }
            }
        }
    }
}
