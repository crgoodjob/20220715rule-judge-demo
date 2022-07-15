package cn.maitian.bss.modules.system.utils;

public enum AssetsRoleEnum {

//    角色相关：

//    assets_dept_business 事业部相关职位
//    assets_big_area_director 大区总监
//    assets_area_manager 区域经理
//    assets_area_assistant 区域助理
//    assets_shop_manager 店长或见习店长
    ASSETS_ROLE("ROLE_","ROLE_"),

    ASSETS_DEPT_BUSINESS("assets_dept_business","事业部相关职位（挂在人上，不用于岗位）"),
    ASSETS_DEPT_GM_ASSISTANT("assets_dept_gm_assistant","事业部总经理助理"),
    ASSETS_BUSINESS_MANAGER("assets_business_manager","事业部总经理"),
    ASSETS_AREA_DIRECTOR("assets_area_director","区域总监"),
    ASSETS_AREA_MANAGER("assets_area_manager","区域经理"),
    ASSETS_AREA_ASSISTANT("assets_area_assistant","区域助理"),
    ASSETS_SHOP_MANAGER("assets_shop_manager","店长或见习店长"),
    ASSETS_COMMISSIONER("assets_commissioner","资产管理专员"),
    ASSETS_ADMIN("admin","管理员");



    private String codeKey;
    private String codeValue;


    AssetsRoleEnum(String codeKey, String codeValue) {
        this.codeKey = codeKey;
        this.codeKey = codeKey;
    }

    public String codeKey() {
        return this.codeKey;
    }

    public String codeValue() {
        return this.codeValue;
    }
}
