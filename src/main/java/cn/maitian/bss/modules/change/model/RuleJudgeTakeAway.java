package cn.maitian.bss.modules.change.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 可带人员限量判定结果
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.RULE_JUDGE_TAKE_AWAY")
public class RuleJudgeTakeAway implements Serializable {


    /**
     * 主键
     */
    private String id;

    /**
     * 任命批次ID
     */
    @TableField("RULE_JUDGE_MAIN_ID")
    private String ruleJudgeMainId;

    /**
     * 任命记录ID-外键
     */
    @TableField("MOVE_INFO_ID")
    private String moveInfoId;

    /**
     * 异动类型（a1.整大区异动，b1.整区域异动，c1.区域更名，d1.大区总监晋升，e1.大区总监异动，f1.大店区经晋升，g1.业务经理晋升，h1.大店区经异动，i1.助理异动，j1.整店异动，k1.店组更名， l1.业务经理异动，m1.新科业务经理，n1.见习业务经理转正，o1.大区总监降职，p1.大店区经降职，q1.业务经理降职； 说明：n1.见习业务经理转正）
     */
    @TableField("CHANGE_TYPE")
    private String changeType;

    /**
     * 任命人身份证
     */
    @TableField("ID_CARD")
    private String idCard;

    /**
     * 任命人姓名
     */
    @TableField("APPOINT_NAME")
    private String appointName;

    /**
     * 被任命人ID
     */
    @TableField("APPOINT_OLD_ID")
    private BigDecimal appointOldId;

    /**
     * 判定结果
     */
    @TableField("JUDGE_RESULT")
    private String judgeResult;

    /**
     * 是否超限量（0：否；1：是）
     */
    @TableField("IS_OVER_LIMIT")
    private String isOverLimit;

    /**
     * 判定状态：1：判定进行中；2：判定结束
     */
    @TableField("JUDGE_STATUS")
    private String judgeStatus;

    /**
     * 判定结束时间
     */
    @TableField("EDIT_TIME")
    private LocalDateTime editTime;

    @TableField(exist = false)
    private String afterShop;
    @TableField(exist = false)
    private String afterArea;
    @TableField(exist = false)
    private String afterBigArea;
    @TableField(exist = false)
    private String afterLargerArea;
}
