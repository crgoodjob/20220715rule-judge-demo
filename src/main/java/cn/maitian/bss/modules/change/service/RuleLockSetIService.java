package cn.maitian.bss.modules.change.service;

import cn.maitian.bss.modules.change.model.RuleLockSet;
import cn.maitian.bss.modules.change.vo.RuleLockSetVO;
import cn.maitian.bss.modules.change.vo.RuleManagerVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 异动锁定集合 服务类
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
public interface RuleLockSetIService extends IService<RuleLockSet> {

    void insertRuleData();

    void test2();

    List<RuleLockSet> queryRuleLockSetList(List<RuleManagerVO> superList);
}
