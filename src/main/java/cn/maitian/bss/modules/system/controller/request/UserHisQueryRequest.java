package cn.maitian.bss.modules.system.controller.request;

import cn.maitian.bss.modules.common.web.PageQueryVO;
import lombok.Data;

import java.util.Date;

@Data
public class UserHisQueryRequest extends PageQueryVO {
    private String id;
    private Date dateStr;
    private String deptId;
}
