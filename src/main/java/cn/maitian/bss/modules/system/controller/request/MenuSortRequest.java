package cn.maitian.bss.modules.system.controller.request;

import lombok.Data;

/**
 * 菜单排序
 */
@Data
public class MenuSortRequest {

    // 菜单ID
    String id;

    // 排序列
    Integer seq;

}
