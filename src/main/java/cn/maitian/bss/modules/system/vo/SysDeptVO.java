package cn.maitian.bss.modules.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 2021-01-09 21:38:24
 */
@Data
public class SysDeptVO implements Serializable {
    // 主键ID
    private String id;

    // 部门父ID
    private String parentId;

    // 部门名称
    private String deptName;

    // 描述信息
    private String description;

    // 部门介绍
    private String deptIntro;

    // 部门类型 1：部门 2：区域 3：租赁区域 4：大区域 5：商铺区域	
    private String deptType;

    // 公司ID
    private String companyId;

    // 部门拼写
    private String deptSpell;

    // 父ID路径：以 "/" 进行分隔
    private String parentPath;

    // 父部门名称：以 "/" 进行分隔
    private String parentName;

    // 地址
    private String address;

    // 电话
    private String tel;

    // 深度
    private Integer deep;

    // 是否删除 0：未删除  1：删除
    private String del;

    // 创建时间
    private Date addTime;

    // 编辑时间
    private Date editTime;

    // 删除时间
    private Date delTime;

    // 创建人
    private String addUser;

    // 删除人
    private String delUser;

    // 编辑人
    private String editUser;

    // 旧系统ID
    private Integer oldId;

    // 旧的父ID
    private Integer oldParentId;

    // 旧的公司ID
    private Integer oldComId;

    // 部门经理ID
    private String managerId;

    // 旧系统部门经理ID
    private Integer oldManagerId;

    // 部门经理的就职时间
    private Date titleTime;

    // 时间截
    private Date timeStamp;

}
