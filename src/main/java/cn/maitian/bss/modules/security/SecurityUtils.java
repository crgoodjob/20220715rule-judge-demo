package cn.maitian.bss.modules.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 安全相关工具类
 *
 * @author liguo
 * @since 2021-08-13
 */
public class SecurityUtils {

    /**
     * 获取当前登录的user
     */
    public static JwtUser getLoginUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null) return null;
            Object object = authentication.getPrincipal();
            if (object != null) return (JwtUser) object;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 获取当前登录的userId
     */
    public static String getUserId() {
        JwtUser loginUser = getLoginUser();
        return loginUser == null ? null : loginUser.getUserId();
    }

    /**
     * 获取当前登录的userLoginName
     */
    public static String getUserLoginName() {
        JwtUser loginUser = getLoginUser();
        return loginUser == null ? null : loginUser.getUsername();
    }

    /**
     * 获取当前登录的姓名
     */
    public static String getName() {
        JwtUser loginUser = getLoginUser();
        return loginUser == null ? null : loginUser.getName();
    }


}
