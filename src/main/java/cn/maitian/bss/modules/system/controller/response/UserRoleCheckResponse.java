package cn.maitian.bss.modules.system.controller.response;

import cn.maitian.bss.modules.system.vo.SysRoleVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户-角色组装复选框数据的VO类
 */
@Data
public class UserRoleCheckResponse implements Serializable {

    private List<SysRoleVO> roleList;

    private List<String> defaultCheckedList;

}
