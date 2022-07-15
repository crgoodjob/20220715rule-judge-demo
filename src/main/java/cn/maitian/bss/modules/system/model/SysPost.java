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
 * 职位表
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_POST")
public class SysPost implements Serializable {

    /**
     * 职位ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 父职位ID
     */
    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 职位名称
     */
    @TableField("POST_NAME")
    private String postName;

    /**
     * 部门ID
     */
    @TableField("DEPT_ID")
    private String deptId;

    /**
     * 公司ID
     */
    @TableField("COMPANY_ID")
    private String companyId;

    /**
     * 深度
     */
    private BigDecimal deep;

    /**
     * 父ID路径：以"/" 进行分隔
     */
    @TableField("PARENT_PATH")
    private String parentPath;

    /**
     * 父职位名称：以"/" 进行分隔
     */
    @TableField("PARENT_NAME")
    private String parentName;

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
     * 编辑人
     */
    @TableField("EDIT_USER")
    private String editUser;

    /**
     * 删除人
     */
    @TableField("DEL_USER")
    private String delUser;

    /**
     * 是否删除: 0:未删除（默认） 1：删除
     */
    private String del;

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
     * 旧的部门ID
     */
    @TableField("OLD_DEPT_ID")
    private BigDecimal oldDeptId;

    /**
     * 旧的公司ID
     */
    @TableField("OLD_COM_ID")
    private BigDecimal oldComId;

    /**
     * 时间截
     */
    @TableField("TIME_STAMP")
    private LocalDateTime timeStamp;


}
