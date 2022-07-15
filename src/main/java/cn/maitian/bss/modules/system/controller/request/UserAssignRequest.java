package cn.maitian.bss.modules.system.controller.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户授权
 */
@Data
public class UserAssignRequest implements Serializable {

    // 用户id
    private String userId;

    // 角色id集合
    private String[] roleIds;
}
