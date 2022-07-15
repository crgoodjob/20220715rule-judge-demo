package cn.maitian.bss.modules.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_USER")
public class SysUser implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 用户登陆名
     */
    @TableField("USER_LOGIN_NAME")
    private String userLoginName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户姓名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 1在职；0离职；2删除 用户状态
     */
    private String status;

    /**
     * 0正常；1帐号锁定；2离职锁定；3考勤锁定；4平级异动锁定
     */
    @TableField("LOCK_STATUS")
    private String lockStatus;

    /**
     * 电话
     */
    private String tel;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 入职时间
     */
    @TableField("HIRE_TIME")
    private LocalDateTime hireTime;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 性别：0：男  1：女
     */
    private String sex;

    /**
     * 身份证号
     */
    @TableField("ID_CARD")
    private String idCard;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 创建时间
     */
    @TableField("ADD_TIME")
    private LocalDateTime addTime;

    /**
     * 修改时间
     */
    @TableField("EDIT_TIME")
    private LocalDateTime editTime;

    /**
     * 密码更新时间
     */
    @TableField("PWD_EDIT_TIME")
    private LocalDateTime pwdEditTime;

    /**
     * 创建人
     */
    @TableField("ADD_USER")
    private String addUser;

    /**
     * 编辑人
     */
    @TableField("EDIT_USER")
    private String editUser;

    /**
     * 公司ID
     */
    @TableField("COMPANY_ID")
    private String companyId;

    /**
     * 部门ID
     */
    @TableField("DEPT_ID")
    private String deptId;

    /**
     * 职位ID
     */
    @TableField("POST_ID")
    private String postId;

    /**
     * 门店ID
     */
    @TableField("SHOP_ID")
    private String shopId;

    /**
     * 旧系统ID
     */
    @TableField("OLD_ID")
    private BigDecimal oldId;

    /**
     * 旧公司ID
     */
    @TableField("OLD_COM_ID")
    private BigDecimal oldComId;

    /**
     * 旧部门ID
     */
    @TableField("OLD_DEPT_ID")
    private BigDecimal oldDeptId;

    /**
     * 旧职位ID
     */
    @TableField("OLD_POST_ID")
    private BigDecimal oldPostId;

    /**
     * 旧门店ID
     */
    @TableField("OLD_SHOP_ID")
    private BigDecimal oldShopId;

    /**
     * 旧的人事ID
     */
    @TableField("OLD_USER_ID")
    private BigDecimal oldUserId;

    /**
     * 复职时间
     */
    @TableField("REINSTATEMENT_TIME")
    private LocalDateTime reinstatementTime;

    /**
     * 员工编号
     */
    @TableField("STAFF_NO")
    private String staffNo;

    /**
     * 离职时间
     */
    @TableField("RESIGNATE_TIME")
    private LocalDateTime resignateTime;

    /**
     * 职级名称
     */
    @TableField("POST_LEVEL_NAME")
    private String postLevelName;

    /**
     * 工号
     */
    @TableField("JOB_NUM")
    private String jobNum;

    /**
     * 合同编号
     */
    @TableField("CONTRACT_NUM")
    private String contractNum;

    /**
     * 时间截
     */
    @TableField("TIME_STAMP")
    private LocalDateTime timeStamp;

    /**
     * 是否签文禾协议:0.否;1.是
     */
    @TableField("IS_WH")
    private String isWh;

}
