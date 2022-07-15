package cn.maitian.bss.modules.system.controller.request;

import cn.maitian.bss.modules.common.web.PageQueryVO;
import lombok.Data;

@Data
public class RoleQueryRequest extends PageQueryVO {
    private String roleName;
    private String roleCode;
}
