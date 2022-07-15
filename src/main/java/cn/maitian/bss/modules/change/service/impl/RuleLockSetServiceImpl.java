package cn.maitian.bss.modules.change.service.impl;

import cn.maitian.bss.modules.change.model.RuleJudgeTakeAway;
import cn.maitian.bss.modules.change.model.RuleLockRelation;
import cn.maitian.bss.modules.change.model.RuleLockSet;
import cn.maitian.bss.modules.change.dao.RuleLockSetMapper;
import cn.maitian.bss.modules.change.model.RuleOccupy;
import cn.maitian.bss.modules.change.service.*;
import cn.maitian.bss.modules.change.utils.DroolsUtils;
import cn.maitian.bss.modules.change.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 异动锁定集合 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Service
@Slf4j
public class RuleLockSetServiceImpl extends ServiceImpl<RuleLockSetMapper, RuleLockSet> implements RuleLockSetIService {

    @Autowired
    private RuleJudgeTakeAwayIService ruleJudgeTakeAwayIService;
    @Autowired
    private RuleLockRelationIService ruleLockRelationIService;
    @Autowired
    private RuleOccupyIService ruleOccupyIService;
    @Autowired
    private RuleLockSetIService ruleLockSetIService;
    @Autowired
    private RuleTakeAwayOccupyIService ruleTakeAwayOccupyIService;

    @Override
    public void insertRuleData() {
        List<RuleJudgeTakeAway> list = ruleJudgeTakeAwayIService.list();

        List<RuleLockSet> setList = this.insertRuleLockSetList(list);
        List<RuleLockRelation> relationList = ruleLockRelationIService.insertRuleLockRelationList(setList);

        List<RuleLockRelationVO2> relationVO2s = ruleLockRelationIService.selectRuleLockRelationVOs();
        List<RuleOccupy> occupyList = ruleOccupyIService.insertRuleOccupyList(setList, relationVO2s);
    }

    private List<RuleLockSet> insertRuleLockSetList(List<RuleJudgeTakeAway> list) {
        List<RuleLockSet> setList = new ArrayList<>();
        for (RuleJudgeTakeAway ta : list) {
            RuleLockSet vo = new RuleLockSet();
            vo.setMoveInfoId(ta.getMoveInfoId());
            vo.setChangeType(ta.getChangeType());
            vo.setAppointName(ta.getAppointName());
            vo.setAppointOldId(ta.getAppointOldId());
            vo.setAppointIdCard(ta.getIdCard());
            vo.setStartDate(LocalDate.of(2022,8,1));
            vo.setEndDate(LocalDate.of(2023, 7, 31));
            vo.setLimitNum(2);
            vo.setState("1");
            vo.setDataType("1");
            setList.add(vo);
        }
        saveBatch(setList);
        return setList;
    }

    @Override
    public void test2() {
        KieContainer kieContainer = DroolsUtils.getKieContainer();
        KieSession kieSession = kieContainer.newKieSession("myChangeSession");
        kieSession.setGlobal("ruleLockRelationIService", ruleLockRelationIService);
        kieSession.setGlobal("ruleLockSetIService", ruleLockSetIService);
        kieSession.setGlobal("ruleOccupyIService", ruleOccupyIService);
        kieSession.setGlobal("ruleTakeAwayOccupyIService", ruleTakeAwayOccupyIService);

        List<RuleManagerVO> managerList = ruleLockRelationIService.getManagerInfo();

        // 没有任命记录，暂时使用 可带人员限量判定结果 子表
        List<RuleJudgeTakeAway> list = ruleJudgeTakeAwayIService.list();
        list = this.setArea(list);
        kieSession.setGlobal("ruleList", list);
        kieSession.setGlobal("managerList", managerList);
        for (RuleJudgeTakeAway vo : list) {
            FactHandle fact = kieSession.insert(vo);

            // RuleJudgeVO vo2 = new RuleJudgeVO();
            // FactHandle fact2 = kieSession.insert(vo2);

            int num = kieSession.fireAllRules();
            kieSession.delete(fact);

            // kieSession.delete(fact2);
        }
        kieSession.dispose();
    }

    private List<RuleJudgeTakeAway> setArea(List<RuleJudgeTakeAway> list) {
        for (RuleJudgeTakeAway vo : list) {
            if (vo.getAppointName().equals("亓松松")) {
                vo.setAfterBigArea("方庄大区");
                vo.setAfterLargerArea("京东南事业部");
            }

            if (vo.getAppointName().equals("宋丙峰")) {
                vo.setAfterLargerArea("京东南事业部");
            }

            if (vo.getAppointName().equals("苗景兰")) {
                vo.setAfterBigArea("方庄大区");
                vo.setAfterLargerArea("京东南事业部");
                vo.setAfterArea("紫芳园区");
            }

            if (vo.getAppointName().equals("何新海")) {
                vo.setAfterLargerArea("京东北事业部");
            }

            if (vo.getAppointName().equals("高攀")) {
                vo.setAfterBigArea("万柳大区");
                vo.setAfterLargerArea("京西南事业部");
                vo.setAfterArea("万柳东区");
            }
        }
        return list;
    }

    /**
     * 根据每个任命的上级，查询上级的异动锁定集合
     * @author ChangRui 
     * @date 2022/7/13 13:56
     * @param superList 
     * @return java.util.List<cn.maitian.bss.modules.change.model.RuleLockSet>
     */
    @Override
    public List<RuleLockSet> queryRuleLockSetList(List<RuleManagerVO> superList) {
        List<BigDecimal> superOldIds = Lists.newArrayList();
        if (superList.size() == 0) {
            return Lists.newArrayList();
        } else {
            for (RuleManagerVO vo : superList) {
                superOldIds.add(vo.getManagerOldId());
            }
            QueryWrapper<RuleLockSet> wrapper = new QueryWrapper<>();
            // TODO 换成一个常量
            wrapper.eq("state", "1");
            wrapper.in("APPOINT_OLD_ID", superOldIds);
            // TODO 判定当前时间，1、填报周期内，取次月1号；2.填报周期外，去当月1号，这个在哪里判定，是否放在规则文件中
            wrapper.le("START_DATE", LocalDate.of(LocalDate.now().plusMonths(1).getYear(), LocalDate.now().plusMonths(1).getMonth(), 1));
            wrapper.gt("END_DATE", LocalDate.of(LocalDate.now().plusMonths(1).getYear(), LocalDate.now().plusMonths(1).getMonth(), 1));
            List<RuleLockSet> result = getBaseMapper().selectList(wrapper);
            log.error("查询上级，有{}个锁定集合", result.size());
            return result;
        }
    }
}
