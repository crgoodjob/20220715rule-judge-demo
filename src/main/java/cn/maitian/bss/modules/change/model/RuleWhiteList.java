package cn.maitian.bss.modules.change.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 任命白名单
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.RULE_WHITE_LIST")
public class RuleWhiteList implements Serializable {


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
     * 晋升类型:1.店长原地晋升;2.区经原地晋升
     */
    @TableField("PROMOTE_TYPE")
    private String promoteType;

    /**
     * 晋升人员ID
     */
    @TableField("PROMOTE_USER_ID")
    private BigDecimal promoteUserId;

    /**
     * 晋升人员身份证号（上级）
     */
    @TableField("PROMOTE_USER_IDCARD")
    private String promoteUserIdcard;

    /**
     * 晋升人员姓名（上级）
     */
    @TableField("PROMOTE_USER_NAME")
    private String promoteUserName;

    /**
     * 白名单开始日期
     */
    @TableField("START_DATE")
    private LocalDateTime startDate;

    /**
     * 白名单结束日期
     */
    @TableField("END_DATE")
    private LocalDateTime endDate;

    /**
     * 白名单ID
     */
    @TableField("WHITE_LIST_ID")
    private BigDecimal whiteListId;

    /**
     * 白名单身份证号
     */
    @TableField("WHITE_LIST_IDCARD")
    private String whiteListIdcard;

    /**
     * 白名单姓名
     */
    @TableField("WHITE_LIST_NAME")
    private String whiteListName;

    /**
     * 白名单状态:1.启用;0.停用
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
    @TableField("RULE_JUDGE_MAIN_ID")
    private String ruleJudgeMainId;

    /**
     * 是否有效的判定依据：0.否;1.是
     */
    @TableField("IS_VALID")
    private String isValid;


}
