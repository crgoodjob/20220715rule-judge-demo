package cn.maitian.bss.modules.change;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-08 17:22
 */
public class RuleConstant {
   // a1.整大区异动，b1.整区域异动，c1.区域更名，d1.大区总监晋升，e1.大区总监异动，f1.大店区经晋升，g1.业务经理晋升，
   // h1.大店区经异动，i1.助理异动，j1.整店异动，k1.店组更名， l1.业务经理异动，m1.新科业务经理，n1.见习业务经理转正，
   // o1.大区总监降职，p1.大店区经降职，q1.业务经理降职； 说明：n1.见习业务经理转正
    /**
     * 异动锁定结合-异动类型
     */
    public static final Map<String, String> RULE_LOCK_SET_MAP = new HashMap<String, String>(){
        {
            put("d1", "大区总监晋升");
            put("e1", "大区总监异动");
            put("f1", "大店区经晋升");
            put("h1", "大店区经异动");
            put("g1", "业务经理晋升");
        }
    };
}
