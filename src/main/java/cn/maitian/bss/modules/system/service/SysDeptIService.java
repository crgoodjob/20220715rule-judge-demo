package cn.maitian.bss.modules.system.service;

import cn.maitian.bss.modules.system.model.SysDept;
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
public interface SysDeptIService extends IService<SysDept> {

    /**
     * 部门树
     *
     * @return
     */
    public List<TreeVO> deptTreeList();

}
