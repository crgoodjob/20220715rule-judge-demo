package cn.maitian.bss.modules.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 2021-01-09 21:38:24
 */
@Data
public class SysPostVO implements Serializable {

    // 主键ID
    private String id;

    // 父职位ID
    private String parentId;

    // 职位名称
    private String postName;

    // 部门ID
    private String deptId;

    // 公司ID
    private String companyId;

    // 深度
    private Integer deep;

    // 父ID路径：以"/" 进行分隔
    private String parentPath;

    // 父职位名称：以"/" 进行分隔
    private String parentName;

    // 创建时间
    private Date addTime;

    // 修改时间
    private Date editTime;

    // 删除时间
    private Date delTime;

    // 创建人
    private String addUser;

    // 编辑人
    private String editUser;

    // 删除人
    private String delUser;

    // 是否删除: 0:未删除（默认） 1：删除
    private String del;

    // 旧系统ID
    private Integer oldId;

    // 旧的父ID
    private Integer oldParentId;

    // 旧的部门ID
    private Integer oldDeptId;

    // 旧的公司ID
    private Integer oldComId;

    // 时间截
    private Date timeStamp;

}
