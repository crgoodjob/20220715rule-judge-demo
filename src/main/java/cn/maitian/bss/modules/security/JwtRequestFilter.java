package cn.maitian.bss.modules.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 请求处理过滤器
 *
 * @author liguo
 * @since 2021-08-13
 */
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;

    public JwtRequestFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String access_token = JwtUtil.getAccessToken(request);
        if (access_token != null) {
            try {
                Claims claims = JwtUtil.parseToken(access_token);
                String username = claims.getSubject();
                JwtUser userDetails = (JwtUser) userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // token将要过期签发新token, 防止突然退出登录
                if ((claims.getExpiration().getTime() - new Date().getTime()) / 1000 / 60 < JwtUtil.TOKEN_WILL_EXPIRE) {
                    String access_token_new = JwtUtil.buildToken(username, userDetails.getName(), userDetails.getUserId());
                    response.addHeader(JwtUtil.TOKEN_HEADER_NAME, access_token_new);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        chain.doFilter(request, response);
    }

}
