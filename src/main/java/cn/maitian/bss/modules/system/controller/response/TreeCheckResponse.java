package cn.maitian.bss.modules.system.controller.response;

import cn.maitian.bss.modules.system.vo.TreeVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 树列表及选择
 */
@Data
public class TreeCheckResponse implements Serializable {

    private List<TreeVO> treeList;

    private List<String> defaultCheckedList;

}
