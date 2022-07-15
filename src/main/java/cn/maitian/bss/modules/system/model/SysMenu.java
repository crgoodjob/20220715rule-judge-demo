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
 * 菜单表
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_MENU")
public class SysMenu implements Serializable {

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
     * 菜单名称
     */
    @TableField("MENU_NAME")
    private String menuName;

    /**
     * URL地址
     */
    private String url;

    /**
     * 跳转目标，如_blank，_self，_parent，_top
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 描述
     */
    private String remark;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 权限码
     */
    @TableField("AUTHORITY_CODE")
    private String authorityCode;

    /**
     * 重定向地址
     */
    @TableField("REDIRECT_URL")
    private String redirectUrl;

    /**
     * 是否显示（0:否，1：是）
     */
    @TableField("IS_SHOW")
    private String isShow;

    /**
     * 是否缓存（0:否，1：是）
     */
    @TableField("IS_KEEP_ALIVE")
    private String isKeepAlive;

    /**
     * 是否隐藏子菜单（0:否，1：是）
     */
    @TableField("IS_HIDE_CHILD")
    private String isHideChild;

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
