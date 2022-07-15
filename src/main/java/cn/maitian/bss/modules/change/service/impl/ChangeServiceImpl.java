package cn.maitian.bss.modules.change.service.impl;

import cn.maitian.bss.modules.change.service.ChangeIService;
import cn.maitian.bss.modules.change.utils.DroolsUtils;
import cn.maitian.bss.modules.change.vo.*;
import cn.maitian.bss.modules.system.vo.SysDeptVO;
import com.alibaba.fastjson.JSON;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-06-27 10:39
 */
@Service
public class ChangeServiceImpl implements ChangeIService {
    @Autowired
    private ChangeIService changeIService;

    @Override
    public void test1() {
        KieContainer kieContainer = DroolsUtils.getKieContainer();
        KieSession kieSession = kieContainer.newKieSession("myChangeSession");
        kieSession.setGlobal("changeIService", changeIService);

        List<RenMingVo> list = getRenMingList();
        kieSession.setGlobal("rmList", list);
        for (RenMingVo vo : list) {
            FactHandle fact = kieSession.insert(vo);
            int num = kieSession.fireAllRules();
            kieSession.delete(fact);
        }
        kieSession.dispose();
    }

    private List<RenMingVo> getRenMingList() {
        List<RenMingVo> list = new ArrayList<>();
        RenMingVo rmvo = new RenMingVo();
        rmvo.setChangeType("大店区经晋升");
        rmvo.setChangeName("张三");
        rmvo.setAfterBigArea("方庄大区");
        rmvo.setAfterLargerArea("京东南片区");
        rmvo.setId("rm_zs");

        RenMingVo rmvo1 = new RenMingVo();
        rmvo1.setChangeType("大区总监晋升");
        rmvo1.setChangeName("李四");
        rmvo1.setAfterLargerArea("京东南片区");
        rmvo1.setId("rm_ls");

        RenMingVo rmvo2 = new RenMingVo();
        rmvo2.setChangeType("业务经理晋升");
        rmvo2.setChangeName("王五");
        rmvo2.setAfterBigArea("方庄大区");
        rmvo2.setAfterLargerArea("京东南片区");
        rmvo2.setId("rm_ww");


        RenMingVo rmvo3 = new RenMingVo();
        rmvo3.setChangeType("大区总监晋升");
        rmvo3.setChangeName("赵六");
        rmvo3.setAfterLargerArea("京东北片区");
        rmvo3.setId("rm_zl");

        RenMingVo rmvo4 = new RenMingVo();
        rmvo4.setChangeType("业务经理晋升");
        rmvo4.setChangeName("钱八");
        rmvo4.setAfterBigArea("亦庄大区");
        rmvo4.setAfterLargerArea("通燕片区");
        rmvo4.setId("rm_qb");

        list.add(rmvo);
        list.add(rmvo1);
        list.add(rmvo2);
        list.add(rmvo3);
        list.add(rmvo4);

        return list;
    }

    @Override
    public List<SysDeptVO> getLargerAreaList() {
        SysDeptVO vo = new SysDeptVO();
        vo.setDeptName("通燕片区");
        vo.setManagerId("孙九");

        SysDeptVO vo1 = new SysDeptVO();
        vo1.setDeptName("京西北片区");
        vo1.setManagerId("常十");

        SysDeptVO vo2 = new SysDeptVO();
        vo2.setDeptName("京东南片区");
        vo2.setManagerId("周十一");

        List<SysDeptVO> list = new ArrayList<>();
        list.add(vo);
        list.add(vo1);
        list.add(vo2);
        return list;
    }

    @Override
    public List<RuleManagerVO> getManagerLeader(String username) {
        System.out.println("drl传入参数：" + username);
        RuleManagerVO vo = new RuleManagerVO();
        vo.setManagerName("李四");
        vo.setIdCard("111");
        vo.setDeptName("京东南片区");

        RuleManagerVO vo1 = new RuleManagerVO();
        vo1.setManagerName("赵六");
        vo1.setIdCard("112");
        vo1.setDeptName("京东北片区");

        RuleManagerVO vo2 = new RuleManagerVO();
        vo2.setManagerName("常十");
        vo2.setIdCard("113");
        vo2.setDeptName("京西北片区");

        RuleManagerVO vo3 = new RuleManagerVO();
        vo3.setManagerName("孙九");
        vo3.setIdCard("114");
        vo3.setDeptName("通燕片区");

        List<RuleManagerVO> list = new ArrayList<>();
        list.add(vo);
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);

        return list;
    }


    /**
     * 通过上级查询异动锁定集合
     */
    @Override
    public List<RuleLockSetVO> getRuleLockSets() {
        RuleLockSetVO vo = new RuleLockSetVO();
        vo.setId("id_1");
        vo.setMoveInfoId("moveInfoId_1");
        vo.setChangeType("大区总监晋升");
        vo.setAppointName("李四");
        vo.setAppointIdCard("111");
        vo.setAppointOldId(1);
        // vo.setStartDate(DateUtils.stringToDate("2022-07-01"));
        // vo.setEndDate(DateUtils.stringToDate("2023-06-30"));
        vo.setStartDate("2022-07-01");
        vo.setEndDate("2023-06-30");
        vo.setLimitNum(1);
        vo.setState("1");
        vo.setDataType("1");

        RuleLockSetVO vo1 = new RuleLockSetVO();
        vo1.setId("id_2");
        vo1.setMoveInfoId("moveInfoId_2");
        vo1.setChangeType("大区总监晋升");
        vo1.setAppointName("赵六");
        vo1.setAppointIdCard("112");
        vo1.setAppointOldId(2);
        vo1.setStartDate("2022-07-01");
        vo1.setEndDate("2023-06-30");
        vo1.setLimitNum(1);
        vo1.setState("1");
        vo1.setDataType("1");

        RuleLockSetVO vo2 = new RuleLockSetVO();
        vo2.setId("id_3");
        vo2.setMoveInfoId("moveInfoId_3");
        vo2.setChangeType("业务经理晋升");
        vo2.setAppointName("钱八");
        vo2.setAppointIdCard("118");
        vo2.setAppointOldId(3);
        vo2.setStartDate("2021-10-01");
        vo2.setEndDate("2022-09-30");
        vo2.setLimitNum(1);
        vo2.setState("1");
        vo2.setDataType("1");



        RuleLockSetVO vo4 = new RuleLockSetVO();
        vo4.setId("id_5");
        vo4.setMoveInfoId("moveInfoId_5");
        vo4.setChangeType("大店区经晋升");
        vo4.setAppointName("张三");
        vo4.setAppointIdCard("115");
        vo4.setAppointOldId(5);
        vo4.setStartDate("2022-07-01");
        vo4.setEndDate("2023-06-30");
        vo4.setLimitNum(1);
        vo4.setState("1");
        vo4.setDataType("1");


        RuleLockSetVO vo3 = new RuleLockSetVO();
        vo3.setId("id_4");
        vo3.setMoveInfoId("moveInfoId_4");
        vo3.setChangeType("业务经理晋升");
        vo3.setAppointName("王五");
        vo3.setAppointIdCard("116");
        vo3.setAppointOldId(4);
        vo3.setStartDate("2021-10-01");
        vo3.setEndDate("2022-09-30");
        vo3.setLimitNum(1);
        vo3.setState("1");
        vo3.setDataType("1");

        List<RuleLockSetVO> list = new ArrayList<>();
        list.add(vo);
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);
        return list;
    }

    @Override
    public List<RuleLockRelationVO> getRuleLockRelations() {

        RuleLockRelationVO vo = new RuleLockRelationVO();
        vo.setCreateType("任命记录");
        vo.setLockSetId("id_1");
        vo.setSubordinateName("张三");
        vo.setSubordinateIdCard("zhangsan");
        vo.setSubordinateOldId("zhangsan");
        vo.setId("gx_1");
        vo.setState("1");
        vo.setDataType("1");

        RuleLockRelationVO vo1 = new RuleLockRelationVO();
        vo1.setCreateType("任命记录");
        vo1.setLockSetId("id_1");
        vo1.setSubordinateName("王五");
        vo1.setSubordinateIdCard("wangwu");
        vo1.setSubordinateOldId("wangwu");
        vo1.setId("gx_2");
        vo1.setState("1");
        vo1.setDataType("1");

        RuleLockRelationVO vo2 = new RuleLockRelationVO();
        vo2.setCreateType("任命记录");
        vo2.setLockSetId("id_5");
        vo2.setSubordinateName("王五");
        vo2.setSubordinateIdCard("wangwu");
        vo2.setSubordinateOldId("wangwu");
        vo2.setId("gx_3");
        vo2.setState("1");
        vo2.setDataType("1");

        RuleLockRelationVO vo3 = new RuleLockRelationVO();
        vo3.setCreateType("任命记录");
        vo3.setLockSetId("id_4");
        vo3.setSubordinateName("钱八");
        vo3.setSubordinateIdCard("qianba");
        vo3.setSubordinateOldId("qianba");
        vo3.setId("gx_4");
        vo3.setState("1");
        vo3.setDataType("1");

        List<RuleLockRelationVO> list = new ArrayList<>();
        list.add(vo);
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        return list;
    }

    @Override
    public List<RuleOccupy> getRuleOccupys() {
        //张三
        RuleOccupy vo = new RuleOccupy();
        vo.setId("occupy_1");
        vo.setCreateType("");
        vo.setLockSetId("id_5");
        vo.setLockRelationId("");
        vo.setSuperiorName("李四");
        vo.setSuperiorIdCard("");
        vo.setSuperiorOldId("");
        vo.setOccupyDate(null);
        vo.setState("");
        vo.setDataType("");

        //王五
        RuleOccupy vo1 = new RuleOccupy();
        vo1.setId("occupy_2");
        vo1.setCreateType("");
        vo1.setLockSetId("id_4");
        vo1.setLockRelationId("");
        vo1.setSuperiorName("李四");
        vo1.setSuperiorIdCard("");
        vo1.setSuperiorOldId("");
        vo1.setOccupyDate(null);
        vo1.setState("");
        vo1.setDataType("");

        //王五
        RuleOccupy vo2 = new RuleOccupy();
        vo2.setId("occupy_3");
        vo2.setCreateType("");
        vo2.setLockSetId("id_4");
        vo2.setLockRelationId("");
        vo2.setSuperiorName("张三");
        vo2.setSuperiorIdCard("");
        vo2.setSuperiorOldId("");
        vo2.setOccupyDate(null);
        vo2.setState("");
        vo2.setDataType("");

        // 钱八
        RuleOccupy vo3 = new RuleOccupy();
        vo3.setId("occupy_4");
        vo3.setCreateType("");
        vo3.setLockSetId("id_3");
        vo3.setLockRelationId("");
        vo3.setSuperiorName("孙九");
        vo3.setSuperiorIdCard("");
        vo3.setSuperiorOldId("");
        vo3.setOccupyDate(null);
        vo3.setState("");
        vo3.setDataType("");


        // RuleOccupy vo4 = new RuleOccupy();
        // vo4.setId("occupy_5");
        // vo4.setCreateType("");
        // vo4.setLockSetId("");
        // vo4.setLockRelationId("");
        // vo4.setSuperiorName("孙九");
        // vo4.setSuperiorIdCard("");
        // vo4.setSuperiorOldId("");
        // vo4.setOccupyDate(null);
        // vo4.setState("");
        // vo4.setDataType("");
        //
        //
        // RuleOccupy vo5 = new RuleOccupy();
        // vo5.setId("occupy_6");
        // vo5.setCreateType("");
        // vo5.setLockSetId("");
        // vo5.setLockRelationId("");
        // vo5.setSuperiorName("孙九");
        // vo5.setSuperiorIdCard("");
        // vo5.setSuperiorOldId("");
        // vo5.setOccupyDate(null);
        // vo5.setState("");
        // vo5.setDataType("");


        List<RuleOccupy> list = new ArrayList<>();
        list.add(vo);
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        // list.add(vo4);
        // list.add(vo5);
        return list;
    }

    @Override
    public void saveRuleTakeAwayOccupyList(ArrayList<RuleTakeAwayOccupyVO> list) {
        for (RuleTakeAwayOccupyVO vo : list) {
            System.out.println(JSON.toJSONString(vo));
        }
    }


    @Override
    public List<String> getRuleShangJiMingList() {
        List<String> s = new ArrayList<>();
        s.add("孙九");
        s.add("李四");
        s.add("张三");
        return s;
    }
}
