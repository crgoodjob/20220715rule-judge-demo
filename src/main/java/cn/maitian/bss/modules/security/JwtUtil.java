package cn.maitian.bss.modules.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Token工具类
 *
 * @author liguo
 * @since 2021-08-13
 */
public class JwtUtil {
    public static final Long TOKEN_EXPIRE_TIME = 60 * 60 * 24L;  // token过期时间,单位秒
    public static final Long REFRESH_TOKEN_EXPIRE_TIME = 60 * 60 * 24L;  // token过期时间,单位秒
    public static final int TOKEN_WILL_EXPIRE = 30;  // token将要过期自动刷新,单位分钟
    public static final String TOKEN_KEY = "ULgNsWJ8rPjRtnjzX/Gv2RGS80Ksnm/ZaLpvIL+NrBg=";  // 生成token的key
    public static final String TOKEN_TYPE = "Bearer";  // token认证类型
    public static final String TOKEN_HEADER_NAME = "Authorization";  // token在header中字段名称
    public static final String TOKEN_PARAM_NAME = "access_token";  // token在参数中字段名称

    /**
     * 获取请求中的access_token
     *
     * @param request HttpServletRequest
     * @return String
     */
    public static String getAccessToken(HttpServletRequest request) {
        String access_token = request.getParameter(TOKEN_PARAM_NAME);
        if (access_token == null || access_token.trim().isEmpty()) {
            access_token = request.getHeader(TOKEN_HEADER_NAME);
            if (access_token != null && access_token.startsWith(TOKEN_TYPE)) {
                access_token = access_token.substring(TOKEN_TYPE.length() + 1);
            }
        }
        return access_token;
    }


    /**
     * 生成token
     *
     * @param userName 登陆名
     * @param name     姓名
     * @param userId   用户ID
     * @return
     */
    public static String buildToken(String userName, String name, String userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, userName);
        claims.put("name", name);
        claims.put("userId", userId);
        Date expireDate = new Date(new Date().getTime() + 1000 * TOKEN_EXPIRE_TIME);
        return buildToken(claims, expireDate);
    }

    /**
     * 生成token
     *
     * @param claims     载体
     * @param expireDate 过期时间
     * @return
     */
    public static String buildToken(Map<String, Object> claims, Date expireDate) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, TOKEN_KEY).setExpiration(expireDate).compact();
    }

    /**
     * 返回一个jwt token对象
     *
     * @param userName 登陆名
     * @param name     姓名
     * @param userId   用户ID
     * @return
     */
    public static JwtTokenVO getJwtToken(String userName, String name, String userId) {
        String token = buildToken(userName, name, userId);
        JwtTokenVO jwtTokenVO = new JwtTokenVO();
        jwtTokenVO.setAccessToken(token);
        jwtTokenVO.setRefreshToken(refreshToken(token));
        jwtTokenVO.setTokenType(TOKEN_TYPE);
        return jwtTokenVO;
    }

    /**
     * 刷新token
     *
     * @param token 原token
     * @return 新token
     */
    public static String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = parseToken(token);
            Date date = new Date();
            long iat = date.getTime() / 1000;
            claims.put(Claims.ISSUED_AT, iat);
            Date expirationDate = new Date(date.getTime() + REFRESH_TOKEN_EXPIRE_TIME);
            refreshedToken = buildToken(claims, expirationDate);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static Claims parseToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token);
        return claimsJws.getBody();
    }


}
