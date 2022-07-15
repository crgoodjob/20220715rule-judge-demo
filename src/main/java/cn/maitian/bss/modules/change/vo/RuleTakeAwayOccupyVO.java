package cn.maitian.bss.modules.change.vo;

import lombok.Data;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-07-05 15:06
 */
@Data
public class RuleTakeAwayOccupyVO {
    private String takeAwayId;
    private String occupyId;

    public RuleTakeAwayOccupyVO(String takeAwayId, String occupyId) {
        this.takeAwayId = takeAwayId;
        this.occupyId = occupyId;
    }

    public RuleTakeAwayOccupyVO() {
    }
}
