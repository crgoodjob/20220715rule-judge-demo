package cn.maitian.bss.modules.system.service.impl;

import cn.maitian.bss.modules.system.dao.SysPostMapper;
import cn.maitian.bss.modules.system.model.SysPost;
import cn.maitian.bss.modules.system.service.SysPostIService;
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
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostIService {

    /**
     * 职位树
     *
     * @return
     */
    @Override
    public List<TreeVO> postTreeList() {
        List<TreeVO> treeList = Lists.newArrayList();
        List<TreeVO> sourceList = getBaseMapper().getPostList();
        TreeUtils.sortTree(treeList, sourceList, TreeUtils.ROOT_ID);
        return treeList;
    }
}
