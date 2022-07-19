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
 * 异动锁定关系
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_LOCK_RELATION")
public class AmLockRelation implements Serializable {


    /**
     * 主键：锁定关系ID
     */
    private String id;

    /**
     * 创建方式（1：任命记录；2:手工新增）
     */
    @TableField("CREATE_TYPE")
    private String createType;

    /**
     * AM_LOCK_SET.ID，外键ID
     */
    @TableField("LOCK_SET_ID")
    private String lockSetId;

    /**
     * 被锁定人姓名：任命人下属姓名
     */
    @TableField("SUBORDINATE_NAME")
    private String subordinateName;

    /**
     * 被锁定人ID：下属人ID
     */
    @TableField("SUBORDINATE_OLD_ID")
    private BigDecimal subordinateOldId;

    /**
     * 被锁定人身份证：下属人身份证
     */
    @TableField("SUBORDINATE_ID_CARD")
    private String subordinateIdCard;

    /**
     * 锁定关系状态（0：停用；1：启用）
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
