package cn.maitian.bss.modules.change.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-05 17:14
 */
@Data
public class RuleTakeTemp {
    private String lockSetId;
    private List<RuleTakeAwayOccupyVO> takes;
}
