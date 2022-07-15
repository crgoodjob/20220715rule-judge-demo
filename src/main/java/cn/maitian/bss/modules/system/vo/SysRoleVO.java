package cn.maitian.bss.modules.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色VO类
 */
@Data
public class SysRoleVO implements Serializable {

    // 角色id
    private String id;

    // 角色名称
    private String roleName;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date updateTime;

    // 备注
    private String remark;

    // 状态
    private String isAvailable;

    // 角色编码
    private String roleCode;

}
