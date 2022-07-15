package cn.maitian.bss.modules.system.controller.request;

import cn.maitian.bss.modules.common.web.PageQueryVO;
import lombok.Data;

@Data
public class UserQueryRequest extends PageQueryVO {
    private String userLoginName;
    private String userName;
    private String deptId;
    private String postId;
}
