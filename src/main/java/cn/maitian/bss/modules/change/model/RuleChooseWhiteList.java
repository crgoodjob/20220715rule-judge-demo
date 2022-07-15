package cn.maitian.bss.modules.change.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 判定结果与任命白名单关系表
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.RULE_CHOOSE_WHITE_LIST")
public class RuleChooseWhiteList implements Serializable {


    /**
     * 选拔人员限量判定明细表id
     */
    @TableId("RULE_JUDGE_CHOOSE_ID")
    private String ruleJudgeChooseId;

    /**
     * 任命白名单id
     */
    @TableField("RULE_WHITE_LIST_ID")
    private String ruleWhiteListId;


}
