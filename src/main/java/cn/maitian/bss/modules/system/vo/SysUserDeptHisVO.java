package cn.maitian.bss.modules.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ่ๅ่กจ
 */
@Data
public class SysUserDeptHisVO implements Serializable {

    private String id;
    private String userId;
    private String deptId;
    private String deptType;
    private String relationType;
    private Date timeStamp;


}
