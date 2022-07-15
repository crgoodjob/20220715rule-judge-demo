package cn.maitian.bss.modules.change.vo;

import lombok.Data;


/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-04 9:23
 */
@Data
public class RuleLockSetVO {
    private String id;
    private String moveInfoId;
    private String changeType;
    private String appointName;
    private Integer appointOldId;
    private String appointIdCard;
    private String startDate;
    private String endDate;
    private Integer limitNum;
    private String state;
    private String dataType;
}
