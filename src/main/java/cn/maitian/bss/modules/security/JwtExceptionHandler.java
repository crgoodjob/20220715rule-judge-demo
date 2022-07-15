package cn.maitian.bss.modules.security;

import cn.maitian.bss.modules.common.web.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异常处理
 *
 * @author liguo
 * @since 2021-08-13
 */
public class JwtExceptionHandler implements AccessDeniedHandler, AuthenticationEntryPoint {

    /**
     * 已登录访问被拒异常处理
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        doHandler(request, response, e);
    }

    /**
     * 未登录访问被拒异常处理
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        doHandler(request, response, e);
    }

    private void doHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Result result;
        if (e instanceof AccessDeniedException) {
            result = Result.failure(403, "没有访问权限");
        } else if (e instanceof InsufficientAuthenticationException) {
            result = Result.failure(401, "未登录");
        } else if (e instanceof AccountExpiredException) {
            result = Result.failure(401, "登录已过期");
        } else {
            result = Result.failure(401, "未登录或登录已过期");
        }
        out.write(JSON.toJSONString(result));
        out.flush();
    }

}
