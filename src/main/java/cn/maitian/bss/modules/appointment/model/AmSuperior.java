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
 * 上级信息表
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_SUPERIOR")
public class AmSuperior implements Serializable {


    /**
     * 主键id
     */
    private String id;

    /**
     * 人员ID
     */
    @TableField("OLD_USER_ID")
    private BigDecimal oldUserId;

    /**
     * 人员身份证号
     */
    @TableField("USER_IDCARD")
    private String userIdcard;

    /**
     * 人员姓名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 职位ID
     */
    @TableField("OLD_POST_ID")
    private BigDecimal oldPostId;

    /**
     * 上级人员ID
     */
    @TableField("OLD_SUPERIOR_ID")
    private BigDecimal oldSuperiorId;

    /**
     * 上级人员身份证号
     */
    @TableField("SUPERIOR_IDCARD")
    private String superiorIdcard;

    /**
     * 上级人员姓名
     */
    @TableField("SUPERIOR_NAME")
    private String superiorName;

    /**
     * 上级职等
     */
    @TableField("SUPERIOR_POST_LEVEL")
    private String superiorPostLevel;

    /**
     * 是否跨级上级：0.否;1.是
     */
    @TableField("IS_CROSS_LEVEL")
    private String isCrossLevel;

    /**
     * 原上级类型:1.店长;2.区经;3.大区总监;4.事业部总经理
     */
    @TableField("SUPERIOR_TYPE")
    private String superiorType;

    /**
     * 开始日期
     */
    @TableField("START_DATE")
    private LocalDateTime startDate;

    /**
     * 结束日期
     */
    @TableField("END_DATE")
    private LocalDateTime endDate;

    /**
     * 当前关系是否截止:0.否;1.是
     */
    @TableField("IS_END")
    private String isEnd;

    /**
     * 更新时间
     */
    @TableField("EDIT_TIME")
    private LocalDateTime editTime;


}
