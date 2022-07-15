package cn.maitian.bss.modules.change.service;

import cn.maitian.bss.modules.change.vo.*;
import cn.maitian.bss.modules.system.vo.SysDeptVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-06-27 10:38
 */
public interface ChangeIService {
    void test1();

    List<SysDeptVO> getLargerAreaList();

    List<RuleManagerVO> getManagerLeader(String userName);

    List<RuleLockSetVO> getRuleLockSets();

    List<RuleLockRelationVO> getRuleLockRelations();

    List<RuleOccupy> getRuleOccupys();

    void saveRuleTakeAwayOccupyList(ArrayList<RuleTakeAwayOccupyVO> list);

    List<String> getRuleShangJiMingList();

}
