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
 * 组织内任命记录
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_APPOINT_ORG")
public class AmAppointOrg implements Serializable {


    /**
     * 主键id
     */
    private String id;

    /**
     * 任命记录表id
     */
    @TableField("MOVE_INFO_ID")
    private String moveInfoId;

    /**
     * 生成方式：1.任命记录;2.手工新增
     */
    @TableField("CREATE_TYPE")
    private String createType;

    /**
     * 晋升类型:1.经纪人晋升;2.店长晋升
     */
    @TableField("PROMOTE_TYPE")
    private String promoteType;

    /**
     * 晋升人员ID
     */
    @TableField("PROMOTE_USER_ID")
    private BigDecimal promoteUserId;

    /**
     * 晋升人员身份证号
     */
    @TableField("PROMOTE_USER_IDCARD")
    private String promoteUserIdcard;

    /**
     * 晋升人员姓名
     */
    @TableField("PROMOTE_USER_NAME")
    private String promoteUserName;

    /**
     * 晋升日期
     */
    @TableField("PROMOTE_DATE")
    private LocalDateTime promoteDate;

    /**
     * 原上级组织ID
     */
    @TableField("SUPERIOR_OLD_ORGID")
    private BigDecimal superiorOldOrgid;

    /**
     * 原上级组织（原组织名）
     */
    @TableField("SUPERIOR_ORG")
    private String superiorOrg;

    /**
     * 任命记录状态:1.启用;0.停用
     */
    private String status;

    /**
     * 操作时间
     */
    @TableField("OPERATE_TIME")
    private LocalDateTime operateTime;

    /**
     * 操作人ID
     */
    @TableField("OPERATE_USER_ID")
    private String operateUserId;

    /**
     * 操作人姓名
     */
    @TableField("OPERATE_USER_NAME")
    private String operateUserName;

    /**
     * 是否正式数据:0.否;1.是
     */
    @TableField("DATA_TYPE")
    private String dataType;

    /**
     * 限量判定批次表ID（临时数据有值）
     */
    @TableField("AM_JUDGE_MAIN_ID")
    private String amJudgeMainId;

    /**
     * 是否有效的判定依据:0.否;1.是（默认）
     */
    @TableField("IS_VALID")
    private String isValid;


}
