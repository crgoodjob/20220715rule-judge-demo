package cn.maitian.bss.modules.change.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 异动锁定集合
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.RULE_LOCK_SET")
public class RuleLockSet implements Serializable {


    /**
     * 主键
     */
    private String id;

    /**
     * 锁定集合ID-任命记录ID
     */
    @TableField("MOVE_INFO_ID")
    private String moveInfoId;

    /**
     * 锁定原因
     */
    @TableField("CHANGE_TYPE")
    private String changeType;

    /**
     * 锁定上级姓名：任命人员
     */
    @TableField("APPOINT_NAME")
    private String appointName;

    /**
     * 锁定上级ID：任命人员ID
     */
    @TableField("APPOINT_OLD_ID")
    private BigDecimal appointOldId;

    /**
     * 锁定上级身份证：任命人员身份证
     */
    @TableField("APPOINT_ID_CARD")
    private String appointIdCard;

    /**
     * 锁定开始日期
     */
    @TableField("START_DATE")
    private LocalDate startDate;

    /**
     * 锁定结束日期
     */
    @TableField("END_DATE")
    private LocalDate endDate;

    /**
     * 免锁限量
     */
    @TableField("LIMIT_NUM")
    private Integer limitNum;

    /**
     * 锁定集合状态（0：停用；1：启用）
     */
    private String state;

    /**
     * 是否正式数据（0：否；1：是）
     */
    @TableField("DATA_TYPE")
    private String dataType;

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


}
