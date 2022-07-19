package cn.maitian.bss.modules.appointment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 限量判定批次表
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_JUDGE_MAIN")
public class AmJudgeMain implements Serializable {


    /**
     * 主键id
     */
    private String id;

    /**
     * 任命月份
     */
    @TableField("BELONG_MONTH")
    private String belongMonth;

    /**
     * 判定类型:1.可带下属限量判定;2.选拔人员限量判定
     */
    @TableField("JUDGE_TYPE")
    private String judgeType;

    /**
     * 判定时间
     */
    @TableField("JUDGE_TIME")
    private LocalDateTime judgeTime;

    /**
     * 参数设置
     */
    private String params;

    /**
     * 执行状态:1.执行开始;2.执行失败;3.执行成功；
     */
    private String status;

    /**
     * 执行开始时间
     */
    @TableField("START_TIME")
    private LocalDateTime startTime;

    /**
     * 执行结束时间
     */
    @TableField("END_TIME")
    private LocalDateTime endTime;

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
     * 是否显示:0.否;1.是
     */
    @TableField("IS_SHOW")
    private String isShow;


}
