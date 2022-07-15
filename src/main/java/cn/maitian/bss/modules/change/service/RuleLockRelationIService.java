package cn.maitian.bss.modules.change.service;

import cn.maitian.bss.modules.change.model.RuleLockRelation;
import cn.maitian.bss.modules.change.model.RuleLockSet;
import cn.maitian.bss.modules.change.model.RuleOccupy;
import cn.maitian.bss.modules.change.vo.RuleLockRelationVO2;
import cn.maitian.bss.modules.change.vo.RuleManagerVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 异动锁定关系 服务类
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
public interface RuleLockRelationIService extends IService<RuleLockRelation> {

    List<RuleLockRelation> insertRuleLockRelationList(List<RuleLockSet> list);

    List<RuleLockRelationVO2> selectRuleLockRelationVOs();

    List<RuleManagerVO> getManagerInfo();

    List<RuleOccupy> queryOccupy(String supName, BigDecimal supOldId, String supIdCard, List<RuleManagerVO> superList);

    List<RuleLockRelation> queryRuleLockRelationList(BigDecimal supOldId, List<RuleLockSet> ruleLockSetS);
}
