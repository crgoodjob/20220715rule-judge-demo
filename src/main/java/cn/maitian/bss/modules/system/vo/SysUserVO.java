package cn.maitian.bss.modules.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class SysUserVO implements Serializable {

    // 主键ID
    private String id;

    // 用户登陆名
    private String userLoginName;

    // 用户密码
    private String password;

    // 用户姓名
    private String userName;

    // 1在职；0离职；2删除 用户状态
    private String status;

    // 0正常；1帐号锁定；2离职锁定；3考勤锁定；4平级异动锁定
    private String lockStatus;

    // 电话
    private String tel;

    // 手机
    private String mobile;

    // 入职时间
    private Date hireTime;

    // 电子邮件
    private String email;

    // 性别：0：男  1：女
    private String sex;

    // 身份证号
    private String idCard;

    // 出生日期
    private Date birthday;

    // 创建时间
    private Date addTime;

    // 修改时间
    private Date editTime;

    // 密码更新时间
    private Date pwdEditTime;

    // 创建人
    private String addUser;

    // 编辑人
    private String editUser;

    // 公司ID
    private String companyId;

    // 部门ID
    private String deptId;

    // 职位ID
    private String postId;

    // 门店ID
    private String shopId;

    // 旧系统ID
    private Integer oldId;

    // 旧公司ID
    private Integer oldComId;

    // 旧部门ID
    private Integer oldDeptId;

    // 旧职位ID
    private Integer oldPostId;

    // 旧门店ID
    private Integer oldShopId;

    // 旧的人事ID
    private Integer oldUserId;

    // 复职时间
    private Date reinstatementTime;

    // 员工编号
    private String staffNo;

    // 离职时间
    private Date resignateTime;

    // 职级名称
    private String postLevelName;

    // 工号
    private String jobNum;

    // 合同编号
    private String contractNum;

    // 时间截
    private Date timeStamp;

    // 是否签文禾协议:0.否;1.是
    private String isWh;

    // 部门名称
    private String deptName;

    // 职位名称
    private String postName;

    // 门店名称
    private String shopName;

    // 部门路径
    private String deptParentPath;

    // 部门路径名称
    private String deptParentName;

}
