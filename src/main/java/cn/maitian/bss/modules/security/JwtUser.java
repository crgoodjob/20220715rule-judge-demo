package cn.maitian.bss.modules.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 自定义的认证用户
 *
 * @author liguo
 * @since 2021-08-13
 */
@Getter
public class JwtUser extends User {

    private String name;

    private String userId;

    public JwtUser(String userId, String userLoginName, String password, String name, Collection<? extends GrantedAuthority> authorities) {
        super(userLoginName, password, authorities);
        this.name = name;
        this.userId = userId;
    }

}