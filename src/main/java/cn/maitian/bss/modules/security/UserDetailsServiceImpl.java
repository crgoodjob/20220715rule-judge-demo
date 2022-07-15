package cn.maitian.bss.modules.security;

import cn.maitian.bss.modules.system.model.SysUser;
import cn.maitian.bss.modules.system.service.SysUserIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户登录验证Service
 *
 * @author liguo
 * @since 2021-08-13
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserIService sysUserIService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserIService.getByUserLoginName(username);

        if (user == null) throw new UsernameNotFoundException("UserLoginName Not Found");

        String authorities = sysUserIService.getUserAuth(user);

        return new JwtUser(user.getId(), user.getUserLoginName(), user.getPassword(), user.getUserName(), AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
    }

}