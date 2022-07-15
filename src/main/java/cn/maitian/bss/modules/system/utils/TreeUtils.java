package cn.maitian.bss.modules.system.utils;

import cn.maitian.bss.modules.system.vo.TreeVO;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    // 32位字符串
    public static final String ROOT_ID = "00000000000000000000000000000000";

    // 递归树
    public static void sortTree(List<TreeVO> list, List<TreeVO> sourceList, String parentId) {
        for (int i = 0; i < sourceList.size(); i++) {
            TreeVO e = sourceList.get(i);
            e.setId(e.getId().trim());
            if ((e.getParentId() != null && (e.getParentId().trim()).equals(parentId)) || ((e.getParentId() == null || "".equals(e.getParentId())) && ROOT_ID.equals(parentId))) {
                list.add(e);
                // 判断是否还有子节点, 有则继续获取子节点
                for (int j = 0; j < sourceList.size(); j++) {
                    TreeVO child = sourceList.get(j);
                    child.setId(child.getId().trim());
                    if (child.getParentId() != null && child.getParentId().equals(e.getId())) {
                        e.setChildren(new ArrayList<>());
                        sortTree(e.getChildren(), sourceList, e.getId());
                        break;
                    }
                }
            }
        }
    }

    // 加载本节点
    public static void sortTreeUp(List<TreeVO> list, List<TreeVO> sourceList, String parentId) {
        for (int i = 0; i < sourceList.size(); i++) {
            TreeVO e = sourceList.get(i);
            e.setId(e.getId().trim());
            if(e.getId() != null && (e.getId().trim()).equals(parentId)){
                e.setChildren(new ArrayList<>());
                list.add(e);
            }
        }
        TreeVO e = list.get(0);
        TreeUtils.sortTree(e.getChildren(), sourceList, e.getId());
    }

}
