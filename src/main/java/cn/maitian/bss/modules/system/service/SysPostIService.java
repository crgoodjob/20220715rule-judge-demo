package cn.maitian.bss.modules.system.service;

import cn.maitian.bss.modules.system.model.SysPost;
import cn.maitian.bss.modules.system.vo.TreeVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liguo
 * @since 2021-07-15
 */
public interface SysPostIService extends IService<SysPost> {

    /**
     * 职位树
     *
     * @return
     */
    public List<TreeVO> postTreeList();
}
