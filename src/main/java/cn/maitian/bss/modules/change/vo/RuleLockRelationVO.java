package cn.maitian.bss.modules.change.vo;

import lombok.Data;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-04 9:57
 */
@Data
public class RuleLockRelationVO {
    private String id;
    private String createType;
    private String lockSetId;
    private String subordinateName;
    private String subordinateOldId;
    private String subordinateIdCard;
    private String state;
    private String dataType;
}
