package cn.maitian.bss.modules.system.vo;

import lombok.Data;

import java.util.List;

/**
 * 菜单表
 */
@Data
public class SysDeptSubmmitVO
{
    private List<String> deptId;
    private String userId;

}
