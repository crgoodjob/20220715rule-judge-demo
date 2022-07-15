package cn.maitian.bss.modules.system.controller.request;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色处理类
 */
@Data
public class RoleHandleRequest implements Serializable {

    // 角色id
    private String id;

    // 角色名称
    private String roleName;

    // 角色英文名称
    private String roleCode;

    // 备注
    private String remark;

    // 状态
    private String isAvailable;

    // 职位id值集合
    List<String> positionIds = new ArrayList<String>();

    // 菜单id值集合
    List<String> menuIds = new ArrayList<String>();

}
