package cn.maitian.bss.modules.change.service;

import cn.maitian.bss.modules.change.model.RuleLockSet;
import cn.maitian.bss.modules.change.model.RuleOccupy;
import cn.maitian.bss.modules.change.vo.RuleLockRelationVO2;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dom4j.rule.Rule;

import java.util.List;

/**
 * <p>
 * 限量占用记录 服务类
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
public interface RuleOccupyIService extends IService<RuleOccupy> {

    List<RuleOccupy> insertRuleOccupyList(List<RuleLockSet> setList, List<RuleLockRelationVO2> relationList);

    List<RuleOccupy> queryOccupyList(List<RuleLockSet> setList);
}
