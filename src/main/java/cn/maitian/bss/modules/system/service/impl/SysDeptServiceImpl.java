package cn.maitian.bss.modules.system.service.impl;

import cn.maitian.bss.modules.system.dao.SysDeptMapper;
import cn.maitian.bss.modules.system.model.SysDept;
import cn.maitian.bss.modules.system.service.SysDeptIService;
import cn.maitian.bss.modules.system.utils.TreeUtils;
import cn.maitian.bss.modules.system.vo.TreeVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptIService {

    /**
     * 部门树
     *
     * @return
     */
    @Override
    public List<TreeVO> deptTreeList() {
        List<TreeVO> treeList = Lists.newArrayList();
        List<TreeVO> sourceList = getBaseMapper().getDeptList();
        TreeUtils.sortTree(treeList, sourceList, TreeUtils.ROOT_ID);
        return treeList;
    }

}
