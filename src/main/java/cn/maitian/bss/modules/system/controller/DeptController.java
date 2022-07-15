package cn.maitian.bss.modules.system.controller;

import cn.maitian.bss.modules.common.web.response.ResponseResult;
import cn.maitian.bss.modules.system.service.SysDeptIService;
import cn.maitian.bss.modules.system.vo.TreeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 部门控制器
 * </p>
 *
 * @author liguo
 * @since 2021-08-13
 */
@Slf4j
@ResponseResult
@RestController
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    private SysDeptIService sysDeptIService;

    @GetMapping("/tree")
    public List<TreeVO> deptTreeList() {
        return sysDeptIService.deptTreeList();
    }
}
