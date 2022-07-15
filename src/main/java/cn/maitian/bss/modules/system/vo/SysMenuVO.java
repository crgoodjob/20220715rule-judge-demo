package cn.maitian.bss.modules.system.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单VO类
 */
@Data
public class SysMenuVO implements Serializable {

    // 主键ID
    private String id;

    // 菜单名称
    private String menuName;

    // 菜单名称
    private String url;

    // 菜单编号（用于显示时排序）
    private Integer seq;

    // 是否为叶子节点
    private Boolean leaf;

    // 父节点:一级菜单为0
    private String parentId;

    // 目标名称
    private String target;

    // 状态
    private String isShow;

    // 是否缓存当前菜单（0否，1是）
    private String isKeepAlive;

    // 重定向地址
    private String redirectUrl;

    // 是否隐藏子集菜单（0否，1是）
    private String isHideChild;

    // 菜单图标
    private String icon;

    // 1、菜单树 2、角色分配菜单，穿梭框使用
    private String key;

    // 角色分配菜单，穿梭框使用
    private String title;

    // 子节点
    @JSONField(serialzeFeatures = {SerializerFeature.WriteMapNullValue})
    private List<SysMenuVO> children;

    // 权限码
    private String authorityCode;

}
