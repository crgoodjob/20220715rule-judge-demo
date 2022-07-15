package cn.maitian.bss.modules.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_ROLE")
public class SysRole implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 父ID
     */
    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 角色编码
     */
    @TableField("ROLE_CODE")
    private String roleCode;

    /**
     * 描述
     */
    private String remark;

    /**
     * 是否可用（0:否，1：是）
     */
    @TableField("IS_AVAILABLE")
    private String isAvailable;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField("CREATE_USER")
    private String createUser;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @TableField("UPDATE_USER")
    private String updateUser;


}
