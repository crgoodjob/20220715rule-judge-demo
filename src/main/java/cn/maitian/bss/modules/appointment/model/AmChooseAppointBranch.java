package cn.maitian.bss.modules.appointment.model;

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
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_CHOOSE_APPOINT_BRANCH")
public class AmChooseAppointBranch implements Serializable {


    /**
     * 选拔人员限量判定明细表id
     */
    @TableId("AM_JUDGE_CHOOSE_ID")
    private String amJudgeChooseId;

    /**
     * 下属任命记录id
     */
    @TableField("AM_APPOINT_BRANCH_ID")
    private String amAppointBranchId;

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
