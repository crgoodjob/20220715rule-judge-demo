package cn.maitian.bss.modules.change.web;

import cn.maitian.bss.modules.change.service.ChangeIService;
import cn.maitian.bss.modules.change.service.RuleLockSetIService;
import cn.maitian.bss.modules.common.web.Result;
import cn.maitian.bss.modules.common.web.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-06-27 10:37
 */
@Slf4j
@ResponseResult
@RestController
@RequestMapping(value = "/change")
public class ChangeController {

    @Autowired
    private ChangeIService changeIService;
    @Autowired
    private RuleLockSetIService ruleLockSetIService;

    /**
     * 规则测试一
     * @return cn.maitian.bss.modules.common.web.Result
     */
    @GetMapping("/test1")
    public Result droolsTest1() {
        changeIService.test1();
        return Result.success();
    }

    /**
     * 规则测试二
     * @return cn.maitian.bss.modules.common.web.Result
     */
    @GetMapping("/test2")
    public Result test2() {
        ruleLockSetIService.test2();
        return Result.success();
    }

    /**
     * 查询填报记录，生成异动锁定集合，和锁定集合
     */
    @GetMapping("/test3")
    public Result test3() {
        ruleLockSetIService.insertRuleData();
        return Result.success();
    }


}
