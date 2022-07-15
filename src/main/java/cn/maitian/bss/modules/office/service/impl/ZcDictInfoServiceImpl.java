package cn.maitian.bss.modules.office.service.impl;

import cn.maitian.bss.modules.office.model.ZcDictInfo;
import cn.maitian.bss.modules.office.dao.ZcDictInfoMapper;
import cn.maitian.bss.modules.office.service.ZcDictInfoIService;
import cn.maitian.bss.modules.office.vo.ZcDictInfoVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2022-04-07
 */
@Service
public class ZcDictInfoServiceImpl extends ServiceImpl<ZcDictInfoMapper, ZcDictInfo> implements ZcDictInfoIService {

    /**
     * 查询数据字典
     * @author ChangRui
     * @date 2022/4/14 22:52
     * @param kindKey
     * @param status
     * @return java.util.List<cn.maitian.bss.modules.office.vo.ZcDictInfoVO>
     */
    @Override
    public List<ZcDictInfoVO> selectDictInfos(String kindKey, String status) {
        return getBaseMapper().selectDictInfos(kindKey, status);
    }
}
