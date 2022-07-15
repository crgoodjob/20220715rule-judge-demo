package cn.maitian.bss.modules.system.dao;

import cn.maitian.bss.modules.system.model.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT ROLE_ID FROM SYS_ROLE_USER WHERE USER_ID = #{userId}")
    List<String> getRoleIdsByUserId(@Param("userId") String userId);

    @Select("SELECT r.id FROM sys_role_post rp left join sys_role r on rp.role_id = r.id WHERE rp.post_id = #{postId}")
    List<String> getRoleListByPostId(@Param("postId") String postId);
    @Select({
            "<script>",
            "select",
            "r.role_code as roleCode",
            "from SYS_ROLE r",
            "where r.is_available=#{isAvailable} and r.id in",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<String> listRoleCodesByRoleIdsAndRoleStatus(@Param("isAvailable")  String isAvailable, @Param("ids") List<String> ids);

    @Select("select r.id,r.role_code as name from sys_role r join sys_role_user u on r.id=u.role_id where r.is_available=#{isAvailable} and u.user_id= #{userId}")
    List<Map<String,String>> getRoleListByUserId(@Param("isAvailable")  String isAvailable, @Param("userId") String userId);

    @Select("select r.id,r.role_code as name from sys_role r join sys_role_user u on r.id=u.role_id join sys_user us on u.user_id=us.id where r.is_available=#{isAvailable} and us.old_user_id= #{oldUserId}")
    List<Map<String,String>> getRoleListByOldUserId(@Param("isAvailable")  String isAvailable,@Param("oldUserId") String oldUserId);

    @Select("SELECT MENU_ID FROM SYS_ROLE_MENU WHERE ROLE_ID = #{roleId}")
    List<String> getMenuIdsByRoleId(@Param("roleId") String roleId);

    @Select("SELECT POST_ID FROM SYS_ROLE_POST WHERE ROLE_ID = #{roleId}")
    List<String> getPostIdsByRoleId(@Param("roleId") String roleId);

    @Select("SELECT ROLE_ID FROM SYS_ROLE_USER WHERE USER_ID = #{userId} UNION SELECT ROLE_ID FROM SYS_ROLE_POST WHERE POST_ID = #{postId}")
    List<String> getRoleIds(@Param("userId") String userId, @Param("postId") String postId);

    @Delete("DELETE FROM SYS_ROLE_USER WHERE USER_ID = #{userId}")
    void deleteRoleUserRelationByUserId(@Param("userId") String userId);

    @Delete("DELETE FROM SYS_ROLE_MENU WHERE ROLE_ID = #{roleId}")
    void deleteRoleMenuRelationByRoleId(@Param("roleId") String roleId);

    @Delete("DELETE FROM SYS_ROLE_POST WHERE ROLE_ID = #{roleId}")
    void deleteRolePostRelationByRoleId(@Param("roleId") String roleId);

    @Delete("DELETE FROM SYS_ROLE_USER WHERE ROLE_ID = #{roleId}")
    void deleteRoleUserRelationByRoleId(@Param("roleId") String roleId);

    @Insert("INSERT INTO SYS_ROLE_USER(USER_ID,ROLE_ID) VALUES(#{userId},#{roleId})")
    void saveRoleUserRelation(@Param("userId") String userId, @Param("roleId") String roleId);

    @Insert("INSERT INTO SYS_ROLE_MENU(MENU_ID,ROLE_ID) VALUES(#{menuId},#{roleId})")
    void saveRoleMenuRelation(@Param("menuId") String menuId, @Param("roleId") String roleId);

    @Insert("INSERT INTO SYS_ROLE_POST(POST_ID,ROLE_ID) VALUES(#{postId},#{roleId})")
    void saveRolePostRelation(@Param("postId") String postId, @Param("roleId") String roleId);

}
