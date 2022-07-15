package cn.maitian.bss.modules.office.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-04-14 22:37
 */
@Data
@ApiModel(description = "图片VO")
public class ZcDictInfoVO {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "顺序索引")
    private Integer codeIndex;

    @ApiModelProperty(value = "字典名称")
    private String codeValue;

    @ApiModelProperty(value = "字典key")
    private String codeKey;

    @ApiModelProperty(value = "类别名称")
    private String kindValue;

    @ApiModelProperty(value = "类别key")
    private String kindKey;

    @ApiModelProperty(value = "父级key")
    private String parentCode;

    // @ApiModelProperty(value = "创建时间")
    // private LocalDateTime createTime;

    // @ApiModelProperty(value = "备注")
    // private String remarks;

    // @ApiModelProperty(value = "有效状态:0：有效；1：无效")
    // private String status;

    // @ApiModelProperty(value = "失效时间")
    // private LocalDateTime deadTime;
}
