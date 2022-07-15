package cn.maitian.bss.modules.security;

import lombok.Data;

import java.io.Serializable;

/**
 * jwtToken的vo类
 *
 * @author liguo
 * @since 2021-08-13
 */
@Data
public class JwtTokenVO implements Serializable {

    // 访问token
    private String accessToken;

    // 刷新token
    private String refreshToken;

    // token类型
    private String tokenType;

}
