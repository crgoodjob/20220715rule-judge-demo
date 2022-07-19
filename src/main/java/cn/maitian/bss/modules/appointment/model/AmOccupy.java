package cn.maitian.bss.modules.appointment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 限量占用记录
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_OCCUPY")
public class AmOccupy implements Serializable {


    /**
     * 主键
     */
    private String id;

    /**
     * 生成方式（1：任命记录；2:手工新增）
     */
    @TableField("CREATE_TYPE")
    private String createType;

    /**
     * 锁定集合外键ID
     */
    @TableField("LOCK_SET_ID")
    private String lockSetId;

    /**
     * 锁定关系ID，外键ID
     */
    @TableField("LOCK_RELATION_ID")
    private String lockRelationId;

    /**
     * 占用日期
     */
    @TableField("OCCUPY_DATE")
    private LocalDateTime occupyDate;

    /**
     * 记录状态（0：停用；1：启用）
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
     * 操作人
     */
    @TableField("OPERATE_USER_ID")
    private String operateUserId;

    /**
     * 操作人
     */
    @TableField("OPERATE_USER_NAME")
    private String operateUserName;


}
