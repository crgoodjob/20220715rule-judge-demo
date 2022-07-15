package cn.maitian.bss.modules.change.service;

import cn.maitian.bss.modules.change.model.RuleTakeAwayOccupy;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 可带人员限量判定-限量占用记录中间表 服务类
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
public interface RuleTakeAwayOccupyIService extends IService<RuleTakeAwayOccupy> {

    void saveRuleTakeAwayOccupyList(List<RuleTakeAwayOccupy> list);
}
