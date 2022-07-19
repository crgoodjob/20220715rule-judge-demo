package cn.maitian.bss.modules.appointment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 判定结果与组织内任命记录关系表
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_CHOOSE_APPOINT_ORG")
public class AmChooseAppointOrg implements Serializable {


    /**
     * 选拔人员限量判定明细表id
     */
    @TableId("AM_JUDGE_CHOOSE_ID")
    private String amJudgeChooseId;

    /**
     * 组织内任命记录id
     */
    @TableField("AM_APPOINT_ORG_ID")
    private String amAppointOrgId;

    /**
     * 原上级组织ID
     */
    @TableField("SUPERIOR_OLD_ORGID")
    private BigDecimal superiorOldOrgid;


}
