package cn.maitian.bss.modules.office.controller;

import cn.maitian.bss.modules.common.web.Result;
import cn.maitian.bss.modules.common.web.response.ResponseResult;
import cn.maitian.bss.modules.office.service.ZcDictInfoIService;
import cn.maitian.bss.modules.office.utils.AssetConstant;
import cn.maitian.bss.modules.office.vo.ZcDictInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 字典表
 * @author ChangRui
 * @version 1.0
 * @date 2022-04-14 17:06
 */
@Api(tags = "数据字典相关接口")
@ResponseResult
@RestController
@RequestMapping("/zc/dict/")
@Slf4j
public class ZcDictInfoController {

    @Autowired
    private ZcDictInfoIService zcDictInfoIService;

    @ApiOperation(value = "数据字典查询", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nodeType", value = "字典类型", required = true, paramType = "path", dataType = "string")
    })
    @GetMapping(value = "/info/{kindKey}")
    public Result<List<ZcDictInfoVO>> dictInfo(@PathVariable String kindKey) {
        List<ZcDictInfoVO> list = zcDictInfoIService.selectDictInfos(kindKey, AssetConstant.STATUS_YES);
        return Result.success(list);
    }
}
