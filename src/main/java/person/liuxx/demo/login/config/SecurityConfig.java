package person.liuxx.demo.login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年3月8日 下午1:44:32
 * @since 1.0.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/index", "/session")
                .permitAll()
                .antMatchers("/test")
                .hasRole("USER")
                .antMatchers("/t1")
                .authenticated();
    }
}