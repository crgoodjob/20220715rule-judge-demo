package cn.maitian.bss.modules.change.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-11 9:05
 */
@Data
public class RuleLockRelationVO2 {

    /**
     * 主键：锁定关系ID
     */
    private String id;

    /**
     * 创建方式（1：任命记录；2:手工新增）
     */
    private String createType;

    /**
     * JYHX_LOCK_SET.ID，外键ID
     */
    private String lockSetId;

    /**
     * 被锁定人姓名：任命人下属姓名
     */
    private String subordinateName;

    /**
     * 被锁定人ID：下属人ID
     */
    private BigDecimal subordinateOldId;

    /**
     * 被锁定人身份证：下属人身份证
     */
    private String subordinateIdCard;

    /**
     * 锁定关系状态（0：停用；1：启用）
     */
    private String state;

    /**
     * 是否正式数据（0：否；1：是）
     */
    private String dataType;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 操作人ID
     */
    private String operateUserId;

    /**
     * 操作人姓名
     */
    private String operateUserName;

    /**
     * 锁定上级姓名：任命人上级
     */
    private String superiorName;

    /**
     * 锁定上级ID
     */
    private BigDecimal superiorOldId;

    /**
     * 锁定上级身份证：任命人上级
     */
    private String superiorIdCard;
}
