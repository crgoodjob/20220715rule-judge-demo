package cn.maitian.bss.modules.security;

import cn.maitian.bss.modules.common.web.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登陆过滤器
 *
 * @author liguo
 * @since 2021-08-13
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
        super.setFilterProcessesUrl("/user/login");
    }

    /**
     * 登录成功签发token返回json数据
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        JwtUser user = (JwtUser) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(Result.success(JwtUtil.getJwtToken(user.getUsername(), user.getName(), user.getUserId()))));
        out.flush();
    }

    /**
     * 登录失败处理
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        String username = request.getParameter("username");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Result result;
        if (e instanceof UsernameNotFoundException) {
            result = Result.failure("账号不存在");
        } else if (e instanceof BadCredentialsException) {
            result = Result.failure("账号或密码错误");
        } else if (e instanceof LockedException) {
            result = Result.failure("账号被锁定");
        } else {
            result = Result.failure(e.getMessage());
        }
        out.write(JSON.toJSONString(result));
        out.flush();
    }

}
