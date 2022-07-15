package cn.maitian.bss.modules.system.dao;

import cn.maitian.bss.modules.system.model.SysMenu;
import cn.maitian.bss.modules.system.vo.SysMenuVO;
import cn.maitian.bss.modules.system.vo.TreeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("SELECT * FROM SYS_MENU ORDER BY SEQ ASC")
    List<SysMenuVO> getMenuList();

    @Select("SELECT * FROM SYS_MENU WHERE PARENT_ID = #{menuId} ORDER BY SEQ ASC")
    List<SysMenuVO> getMenuListByParentId(@Param("menuId") String menuId);

    @Select("SELECT ID,PARENT_ID,MENU_NAME AS NAME FROM SYS_MENU ORDER BY SEQ ASC")
    List<TreeVO> getMenuTreeList();

    List<SysMenu> getMenuListByRoleIdList(@Param("roleIdList") List<String> roleIdList);

    List<SysMenu> getAllMenuListByRoleIdList(@Param("roleIdList") List<String> roleIdList);
}
