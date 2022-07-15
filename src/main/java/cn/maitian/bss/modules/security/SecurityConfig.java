package cn.maitian.bss.modules.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * 安全配置
 *
 * @author liguo
 * @since 2021-08-13
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers(HttpMethod.GET, "/favicon.ico", "/api/file/**", "/", "/change/**", "/assets/**", "/**.html")
            .permitAll()
            .antMatchers("/user/doLogin","/**", "/user/login", "/user/mobile/login", "/zc/office/id", "/error", "/druid/**", "/webjars/**", "/v3/**", "/swagger-ui.html", "/swagger-resources/**", "/swagger-ui/**","/doc.html").permitAll()
            .anyRequest().authenticated()
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().headers().frameOptions().disable()
            .and().cors().and().csrf().disable();
        http.exceptionHandling().accessDeniedHandler(jwtExceptionHandler()).authenticationEntryPoint(jwtExceptionHandler());
        http.logout().logoutUrl("/user/logout").logoutSuccessHandler(jwtLogoutSuccessHandler());
        http.addFilterBefore(jwtLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl()).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }

    @Bean
    public UserDetailsServiceImpl userDetailsServiceImpl() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public JwtLoginFilter jwtLoginFilter() throws Exception {
        return new JwtLoginFilter(authenticationManagerBean());
    }

    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter(userDetailsServiceImpl());
    }

    @Bean
    public JwtLogoutSuccessHandler jwtLogoutSuccessHandler() {
        return new JwtLogoutSuccessHandler();
    }

    @Bean
    public JwtExceptionHandler jwtExceptionHandler() {
        return new JwtExceptionHandler();
    }

}
