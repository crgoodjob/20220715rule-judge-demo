package cn.maitian.bss.modules.system.dao;

import cn.maitian.bss.modules.system.model.SysUser;
import cn.maitian.bss.modules.system.vo.TreeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Select("SELECT count(1) from sys_user ")
    String selectCount();

    void insertBatch(List<SysUser> userList);
}
