package cn.maitian.bss.modules.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_DEPARTMENT")
public class SysDept implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 部门父ID
     */
    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 部门名称
     */
    @TableField("DEPT_NAME")
    private String deptName;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 部门介绍
     */
    @TableField("DEPT_INTRO")
    private String deptIntro;

    /**
     * 部门类型 1：部门 2：区域 3：租赁区域 4：大区域 5：商铺区域
     */
    @TableField("DEPT_TYPE")
    private String deptType;

    /**
     * 公司ID
     */
    @TableField("COMPANY_ID")
    private String companyId;

    /**
     * 部门拼写
     */
    @TableField("DEPT_SPELL")
    private String deptSpell;

    /**
     * 父ID路径：以 "/" 进行分隔
     */
    @TableField("PARENT_PATH")
    private String parentPath;

    /**
     * 父部门名称：以 "/" 进行分隔
     */
    @TableField("PARENT_NAME")
    private String parentName;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String tel;

    /**
     * 深度
     */
    private BigDecimal deep;

    /**
     * 是否删除 0：未删除  1：删除
     */
    private String del;

    /**
     * 创建时间
     */
    @TableField("ADD_TIME")
    private LocalDateTime addTime;

    /**
     * 编辑时间
     */
    @TableField("EDIT_TIME")
    private LocalDateTime editTime;

    /**
     * 删除时间
     */
    @TableField("DEL_TIME")
    private LocalDateTime delTime;

    /**
     * 创建人
     */
    @TableField("ADD_USER")
    private String addUser;

    /**
     * 删除人
     */
    @TableField("DEL_USER")
    private String delUser;

    /**
     * 编辑人
     */
    @TableField("EDIT_USER")
    private String editUser;

    /**
     * 旧系统ID
     */
    @TableField("OLD_ID")
    private BigDecimal oldId;

    /**
     * 旧的父ID
     */
    @TableField("OLD_PARENT_ID")
    private BigDecimal oldParentId;

    /**
     * 旧的公司ID
     */
    @TableField("OLD_COM_ID")
    private BigDecimal oldComId;

    /**
     * 部门经理ID
     */
    @TableField("MANAGER_ID")
    private String managerId;

    /**
     * 旧系统部门经理ID
     */
    @TableField("OLD_MANAGER_ID")
    private BigDecimal oldManagerId;

    /**
     * 部门经理的就职时间
     */
    @TableField("TITLE_TIME")
    private LocalDateTime titleTime;

    /**
     * 时间截
     */
    @TableField("TIME_STAMP")
    private LocalDateTime timeStamp;


}
