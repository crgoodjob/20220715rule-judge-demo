package cn.maitian.bss.modules.change.vo;

import lombok.Data;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-06-27 10:30
 */
@Data
public class RenMingVo {
    private String changeType; // 异动类型
    private String afterArea;
    private String afterBigArea;
    private String afterLargerArea;
    private String changeName;
    private String id;
}
