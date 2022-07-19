package cn.maitian.bss.modules.appointment.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 参数配置
 * </p>
 *
 * @author liguo
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("BSS_HTS_BEIJING.AM_CONFIG")
public class AmConfig implements Serializable {


    /**
     * 主键
     */
    private String id;

    /**
     * 配置模块类型（1：可带下属限量；2：选拔人员限量）
     */
    @TableField("MODULE_TYPE")
    private String moduleType;

    /**
     * 配置文本描述
     */
    @TableField("CONFIG_TEXT")
    private String configText;

    /**
     * 配置项key
     */
    @TableField("CONFIG_KEY")
    private String configKey;

    /**
     * 配置项value
     */
    @TableField("CONFIG_VALUE")
    private Integer configValue;

    /**
     * 状态（0：有效；1：无效；9：删除）
     */
    private String status;

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
