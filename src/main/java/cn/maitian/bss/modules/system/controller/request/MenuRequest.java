package cn.maitian.bss.modules.system.controller.request;


import lombok.Data;

import java.io.Serializable;


@Data
public class MenuRequest implements Serializable {

    // 菜单id
    private String id;

    // 父节点
    private String parentId;

    // 菜单名称
    private String menuName;

    // 菜单地址
    private String url;

    // 排序列
    private Integer seq;

    // 目标名称
    private String target;

    // 是否显示（0:否，1：是）
    private String isShow;

    // 菜单图标
    private String icon;

    // 权限编码
    private String authorityCode;

    // 是否缓存当前菜单（0否，1是）
    private String isKeepAlive;

    // 重定向地址
    private String redirectUrl;

    // 是否隐藏子集菜单（0否，1是）
    private String isHideChild;

}
