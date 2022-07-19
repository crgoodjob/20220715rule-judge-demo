package cn.maitian.bss.modules.appointment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 选拔人员限量判定明细
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_JUDGE_CHOOSE")
public class AmJudgeChoose implements Serializable {


    /**
     * 主键id
     */
    private String id;

    /**
     * 任命记录表ID
     */
    @TableField("MOVE_INFO_ID")
    private String moveInfoId;

    /**
     * 限量判定批次表ID
     */
    @TableField("AM_JUDGE_MAIN_ID")
    private String amJudgeMainId;

    /**
     * 异动类型：a1.整大区异动，b1.整区域异动，c1.区域更名，d1.大区总监晋升，e1.大区总监异动，f1.大店区经晋升，g1.业务经理晋升，h1.大店区经异动，i1.助理异动，j1.整店异动，k1.店组更名， l1.业务经理异动，m1.新科业务经理，n1.见习业务经理转正，o1.大区总监降职，p1.大店区经降职，q1.业务经理降职；
     */
    @TableField("CHANGE_TYPE")
    private String changeType;

    /**
     * 任命人员ID
     */
    @TableField("APPOINT_USER_ID")
    private BigDecimal appointUserId;

    /**
     * 身份证号
     */
    @TableField("ID_CARD")
    private String idCard;

    /**
     * 姓名
     */
    @TableField("APPOINT_NAME")
    private String appointName;

    /**
     * 是否超限量:0.否;1.是
     */
    @TableField("IS_OVER_LIMIT")
    private String isOverLimit;

    /**
     * 判定结果
     */
    @TableField("JUDGE_RESULT")
    private String judgeResult;

    /**
     * 判断状态:1.判断进行中;2.判断完成
     */
    @TableField("JUDGE_STATUS")
    private String judgeStatus;

    /**
     * 判断结束时间
     */
    @TableField("EDIT_TIME")
    private LocalDateTime editTime;


}
