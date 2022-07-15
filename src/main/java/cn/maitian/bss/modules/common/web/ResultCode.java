package cn.maitian.bss.modules.common.web;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(200, "成功"),//成功
    FAILURE(100000, "失败"),
    SUCCESS_CHECK(200000, "成功"),//成功
    //FAIL(400, "失败"),//失败
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "认证失败"),//未认证
    ACCESS_DENIED(403, "没有访问权限"),
    NOT_FOUND(404, "接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500, "系统繁忙"),//服务器内部错误
    METHOD_NOT_ALLOWED(405, "方法不被允许"),

    LOGIN_FAILURE(1200001, "账号或密码错误。请重试"),

    /*参数错误:1001-1999*/
    PARAMS_IS_INVALID(1001, "参数无效"),
    PARAMS_IS_BLANK(1002, "参数为空"),
    USER_NOT_FOUND(2004, "用户不存在"),
    /*用户错误2001-2999*/

    INVALID_ARGUMENT(777, "参数无效"),

    // 角色
    ROLE_NOT_FOUND(40004, "角色不存在"),
    ROLE_NAME_EXIST(40014, "角色名称已存在"),
    ROLE_CODE_EXIST(40024, "角色编码已存在"),

    // 菜单
    MENU_SUB_NAME_EXIST(900001, "同级菜单名称不能重复"),
    MENU_NOT_FOUND(900002, "没有此信息"),
    MENU_HAVE_CHILDREN(900003, "存在子菜单"),
    MENU_HAVE_ROLE(900004, "有角色包含此菜单,要解除所有关联后才能删除。"),

    //流程相关
    PROC_DEF_ID_NOT_EMPTY(1700001,"流程定义ID不能为空"),
    ACT_ID_NOT_EMPTY(1700051,"流程节点ID不能为空"),
    FALL_BACK_FAILURE(180001,"流程回退失败"),
    FIRST_BACK_FAILURE(180002,"流程驳回失败"),
    FINISH_END_FAILURE(180003,"流程结束失败"),


    // 校验
    CLASS_EXISTS(500000,"分类已存在"),
    CLASS_NUM_EXISTS(500001,"分类序号已存在"),
    GOODS_NUM_EXISTS(500002,"商品序号已存在"),
    GOODS_SPEC_NUM_EXISTS(500003,"规格序号已存在"),
    GOODS_SPEC_VALUE_EXISTS(500004,"规格值已存在"),

    APPLY_TIME_OUT(500100,"当前日期不可申请"),
    SHOP_NOT_FOUND(500101,"未获取到您的店组信息"),
    LARGE_AREA_NOT_FOUND(500102,"未获取到您的事业部信息"),
    APPLY_EXIST(500103,"您本月已提交申请"),
    OFFICE_NOT_EMPTY(500104,"所选办公用品不能为空"),
    CONFIG_NOT_FOUND(500105,"未获取到系统设置"),
    DELETE_TIME_OUT(500106,"当前日期不可删除"),
    CLEAR_TIME_OUT(500107,"当前日期不可清空"),
    MOVE_GOODS(500108,"系统已为您移除停用商品"),
    APPLY_IS_DELETE(500109,"此申请记录已删除"),
    OUT_LIMIT_MONEY(500110,"已到达限额"),
    GOODS_NOT_FOUND(500111,"添加的办公用品不存在"),
    OFFICE_NO_ERROR(500112,"生成申请编号失败"),;


    private Integer code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}