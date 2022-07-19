package cn.maitian.bss.modules.appointment.model;

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
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_CHOOSE_WHITE_LIST")
public class AmChooseWhiteList implements Serializable {


    /**
     * 选拔人员限量判定明细表id
     */
    @TableId("AM_JUDGE_CHOOSE_ID")
    private String amJudgeChooseId;

    /**
     * 任命白名单id
     */
    @TableField("AM_WHITE_LIST_ID")
    private String amWhiteListId;


}
