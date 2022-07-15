package cn.maitian.bss.modules.change.vo;

import cn.maitian.bss.modules.change.model.RuleLockSet;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 判定条件VO，用于规则条件更新
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-11 9:36
 */
@Data
public class RuleJudgeVO {
    // 可带人员限量判定结果ID
    private String takeAwayId;

    // 异动锁定集合ID
    private String lockSetId;

    private String changeType;

    // 任命人身份证
    private String idCard;

    // 任命人姓名
    private String appointName;

    // 被任命人ID
    private BigDecimal appointOldId;

    private String judgeResult;
    private String isOverLimit;
    private String judgeStatus;

    // 上级信息
    // private String superiorName;
    // private String superiorOldId;
    // private String superiorIdCard;

    private String afterArea;
    private String afterBigArea;
    private String afterLargerArea;
    private String afterShop;

    // 是否有上级任命，0：否，1：是
    private String hasSuperior;

    // 是否有下级任命，0：否，1：是
    private String hasSup;

    // 上级集合
    private List<RuleManagerVO> managerVOS;

    // 限量设置量
    private Integer limitNum;

    private List<RuleLockSet> lockSets;
}
