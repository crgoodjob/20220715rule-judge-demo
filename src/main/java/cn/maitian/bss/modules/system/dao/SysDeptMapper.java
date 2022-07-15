package cn.maitian.bss.modules.system.dao;

import cn.maitian.bss.modules.system.model.SysDept;
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
public interface SysDeptMapper extends BaseMapper<SysDept> {

    @Select("SELECT * FROM (SELECT ID,PARENT_ID,DEPT_NAME AS NAME FROM SYS_DEPARTMENT WHERE DEL = '0' ORDER BY DEPT_NAME,ADD_TIME DESC) UNION ALL SELECT * FROM (SELECT ID,DEPT_ID,SHOP_NAME AS NAME FROM SYS_SHOP WHERE DEL = '0' ORDER BY SHOP_NAME,ADD_TIME DESC)")
    List<TreeVO> getDeptList();

}
