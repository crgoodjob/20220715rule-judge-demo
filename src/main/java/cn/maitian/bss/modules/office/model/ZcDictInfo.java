package cn.maitian.bss.modules.office.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author liguo
 * @since 2022-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ZC_DICT_INFO")
public class ZcDictInfo implements Serializable {


    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 顺序索引
     */
    @TableField("CODE_INDEX")
    private Integer codeIndex;

    /**
     * 字典名称
     */
    @TableField("CODE_VALUE")
    private String codeValue;

    /**
     * 字典key
     */
    @TableField("CODE_KEY")
    private String codeKey;

    /**
     * 类别名称
     */
    @TableField("KIND_VALUE")
    private String kindValue;

    /**
     * 类别key
     */
    @TableField("KIND_KEY")
    private String kindKey;

    /**
     * 父级key
     */
    @TableField("PARENT_CODE")
    private String parentCode;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 有效状态:0：有效；1：无效
     */
    private String status;

    /**
     * 失效时间
     */
    @TableField("DEAD_TIME")
    private LocalDateTime deadTime;


}
