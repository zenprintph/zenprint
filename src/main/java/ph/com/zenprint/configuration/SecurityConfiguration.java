package ph.com.zenprint.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ph.com.zenprint.constant.Roles;
import ph.com.zenprint.service.DefaultUserDetailsService;

/**
 * @author Choy
 * @date 10/22/2020.
 */

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DefaultUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().and()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority(Roles.ADMIN.name())
                .antMatchers("/user/**").hasAnyAuthority(Roles.ADMIN.name(),
                    Roles.USER.name())
                .antMatchers("/","/register")
                .permitAll()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean("passwordEncoder")
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}