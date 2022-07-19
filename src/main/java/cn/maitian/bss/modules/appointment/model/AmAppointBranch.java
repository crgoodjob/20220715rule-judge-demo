package cn.maitian.bss.modules.appointment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 下属任命记录
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_APPOINT_BRANCH")
public class AmAppointBranch implements Serializable {


    /**
     * 主键id
     */
    private String id;

    /**
     * 任命记录表id
     */
    @TableId("MOVE_INFO_ID")
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
     * 原上级ID
     */
    @TableField("SUPERIOR_OLD_ID")
    private BigDecimal superiorOldId;

    /**
     * 原上级身份证号
     */
    @TableField("SUPERIOR_IDCARD")
    private String superiorIdcard;

    /**
     * 原上级姓名
     */
    @TableField("SUPERIOR_NAME")
    private String superiorName;

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
     * 限量判定批次表ID
     */
    @TableField("AM_JUDGE_MAIN_ID")
    private String amJudgeMainId;


}
