package cn.maitian.bss.modules.change.service.impl;

import cn.maitian.bss.modules.change.model.RuleTakeAwayOccupy;
import cn.maitian.bss.modules.change.dao.RuleTakeAwayOccupyMapper;
import cn.maitian.bss.modules.change.service.RuleTakeAwayOccupyIService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 可带人员限量判定-限量占用记录中间表 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Service
public class RuleTakeAwayOccupyServiceImpl extends ServiceImpl<RuleTakeAwayOccupyMapper, RuleTakeAwayOccupy> implements RuleTakeAwayOccupyIService {

    @Override
    public void saveRuleTakeAwayOccupyList(List<RuleTakeAwayOccupy> list) {
        saveBatch(list);

    }
}
