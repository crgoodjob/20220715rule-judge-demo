package cn.maitian.bss.modules.office.service;

import cn.maitian.bss.modules.office.model.ZcDictInfo;
import cn.maitian.bss.modules.office.vo.ZcDictInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author liguo
 * @since 2022-04-07
 */
public interface ZcDictInfoIService extends IService<ZcDictInfo> {
    
    /**
     * 查询数据字典
     * @author ChangRui 
     * @date 2022/4/14 22:52
     * @param kindKey 
     * @param status
     * @return java.util.List<cn.maitian.bss.modules.office.vo.ZcDictInfoVO>
     */
    List<ZcDictInfoVO> selectDictInfos(String kindKey, String status);
}
