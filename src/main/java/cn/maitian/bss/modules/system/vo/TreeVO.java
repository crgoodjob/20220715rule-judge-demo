package cn.maitian.bss.modules.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TreeVO implements Serializable {
    private String id;
    private String parentId;
    private String name;
    private List<TreeVO> children;
}
