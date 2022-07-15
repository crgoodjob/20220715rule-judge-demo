package cn.maitian.bss.modules.change.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 可带人员限量判定-限量占用记录中间表
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.RULE_TAKE_AWAY_OCCUPY")
public class RuleTakeAwayOccupy implements Serializable {


    /**
     * 可带人员限量判定结果ID-外键ID
     */
    @TableId("TAKE_AWAY_ID")
    private String takeAwayId;

    /**
     * 限量占用记录ID-外键ID
     */
    @TableField("OCCUPY_ID")
    private String occupyId;


}
