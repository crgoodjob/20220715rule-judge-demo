package cn.maitian.bss.modules.change.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-04 10:04
 */
@Data
public class RuleOccupy {
    private String id;
    private String createType;
    private String lockSetId;
    private String lockRelationId;
    private String superiorName;
    private String superiorOldId;
    private String superiorIdCard;
    private Date occupyDate;
    private String state;
    private String dataType;
}
