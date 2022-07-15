package cn.maitian.bss.modules.office.dao;

import cn.maitian.bss.modules.office.model.ZcDictInfo;
import cn.maitian.bss.modules.office.vo.ZcDictInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author liguo
 * @since 2022-04-07
 */
public interface ZcDictInfoMapper extends BaseMapper<ZcDictInfo> {

    @Select("SELECT id,code_index,code_value,code_key,kind_value,kind_key,parent_code,remarks " +
            "FROM ZC_DICT_INFO WHERE status = #{status} AND kind_key = #{kindKey} ORDER BY code_index")
    List<ZcDictInfoVO> selectDictInfos(String kindKey, String status);
}
