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
 * 限量占用记录
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.RULE_OCCUPY")
public class RuleOccupy implements Serializable {


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

    // /**
    //  * 锁定上级姓名：任命人上级
    //  */
    // @TableField("SUPERIOR_NAME")
    // private String superiorName;
    //
    // /**
    //  * 锁定上级ID
    //  */
    // @TableField("SUPERIOR_OLD_ID")
    // private BigDecimal superiorOldId;
    //
    // /**
    //  * 锁定上级身份证：任命人上级
    //  */
    // @TableField("SUPERIOR_ID_CARD")
    // private String superiorIdCard;

    /**
     * 占用日期
     */
    @TableField("OCCUPY_DATE")
    private LocalDate occupyDate;

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
