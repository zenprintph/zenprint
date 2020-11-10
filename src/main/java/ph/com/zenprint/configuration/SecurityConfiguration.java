package ph.com.zenprint.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ph.com.zenprint.constant.Roles;
import ph.com.zenprint.interceptor.RequestLoggingFilter;
import ph.com.zenprint.service.DefaultUserDetailsService;

/**
 * @author Choy
 * @date 10/22/2020.
 */

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DefaultUserDetailsService userDetailsService;

    private RequestLoggingFilter requestLoggingFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority(Roles.ADMIN.name())
                .antMatchers("/user/**", "/zenprint/**").hasAnyAuthority(Roles.ADMIN.name(), Roles.USER.name())
                .antMatchers("/", "/register", "/authenticate")
                .permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().and().sessionManagement()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();

        http.addFilterBefore(requestLoggingFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean("passwordEncoder")
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void setRequestLoggingFilter(RequestLoggingFilter requestLoggingFilter) {
        this.requestLoggingFilter = requestLoggingFilter;
    }
}