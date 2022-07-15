package cn.maitian.bss.modules.system.dao;

import cn.maitian.bss.modules.system.model.SysPost;
import cn.maitian.bss.modules.system.vo.TreeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Repository
public interface SysPostMapper extends BaseMapper<SysPost> {

    @Select("SELECT ID,PARENT_ID,POST_NAME AS NAME FROM SYS_POST WHERE DEL = '0' ORDER BY POST_NAME,ADD_TIME DESC")
    List<TreeVO> getPostList();

}
