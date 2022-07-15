package cn.maitian.bss.modules.change.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 判定结果与下属任命记录关系表
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.RULE_CHOOSE_APPOINT_BRANCH")
public class RuleChooseAppointBranch implements Serializable {


    /**
     * 选拔人员限量判定明细表id
     */
    @TableId("RULE_JUDGE_CHOOSE_ID")
    private String ruleJudgeChooseId;

    /**
     * 下属任命记录id
     */
    @TableField("RULE_APPOINT_BRANCH_ID")
    private String ruleAppointBranchId;

    /**
     * 是否白名单:0.否;1.是
     */
    @TableField("IS_WHITE_LIST")
    private String isWhiteList;

    /**
     * 原上级身份证号
     */
    @TableField("ID_CARD")
    private String idCard;


}
