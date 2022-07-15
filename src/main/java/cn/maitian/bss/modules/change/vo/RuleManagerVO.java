package cn.maitian.bss.modules.change.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-04 13:41
 */
@Data
public class RuleManagerVO {
    private String deptId;
    private String deptName;

    private String managerName;
    private String idCard;
    private String managerId;
    private BigDecimal managerOldId;

    private String parentDeptName;
    private String parentDeptId;

    // 是否是本次任命：0：否；1：是
    private String isNowMove;
}
