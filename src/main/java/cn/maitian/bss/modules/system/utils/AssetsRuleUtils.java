package cn.maitian.bss.modules.system.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChangRui
 * @version 1.0
 * @date 2022-04-18 13:39
 */
public class AssetsRuleUtils {

    /**
     * 管理员
     * @author ChangRui
     * @date 2022/4/18 13:53
     * @param request
     * @return boolean
     */
    public static boolean isAdmin(HttpServletRequest request) {
        return request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_ADMIN.codeKey());
    }

    /**
     * 资产管理专员
     * @author ChangRui
     * @date 2022/4/18 13:53
     * @param request
     * @return boolean
     */
    public static boolean isCommissioner(HttpServletRequest request) {
        return request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_COMMISSIONER.codeKey());
    }

    /**
     * 店长或见习店长
     * @param request
     * @return
     */
    public static boolean isShopManager(HttpServletRequest request) {
        return request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_SHOP_MANAGER.codeKey());
    }

    /**
     * 事业部相关职位（挂在人上，不用于岗位）
     * @param request
     * @return
     */
    public static boolean isDeptBusiness(HttpServletRequest request) {
        return request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_DEPT_BUSINESS.codeKey());
    }

    /**
     * 是否固定资产发起申请权限
     * 分店经理、见习店经理、区域助理、区域经理、事业部总经理助理
     * @param request
     * @return
     */
    public static boolean isAssetsApply(HttpServletRequest request) {
        return request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_SHOP_MANAGER.codeKey())
                || request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_AREA_ASSISTANT.codeKey())
                || request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_AREA_MANAGER.codeKey())
                || request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_DEPT_GM_ASSISTANT.codeKey())
                ;
    }

    /**
     * 是否固定资产流程审批权限
     * 分店经理、见习店经理、区域助理、区域经理、区域总监、事业部总经理助理、事业部总经理
     * @param request
     * @return
     */
    public static boolean isAssetsApprove(HttpServletRequest request) {
        return request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_SHOP_MANAGER.codeKey())
                || request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_AREA_ASSISTANT.codeKey())
                || request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_AREA_MANAGER.codeKey())
                || request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_AREA_DIRECTOR.codeKey())
                || request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_DEPT_GM_ASSISTANT.codeKey())
                || request.isUserInRole(AssetsRoleEnum.ASSETS_ROLE.codeKey() + AssetsRoleEnum.ASSETS_BUSINESS_MANAGER.codeKey())
                ;
    }
}
