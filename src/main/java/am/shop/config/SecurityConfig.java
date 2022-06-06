package am.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //sranov pagum enq bolor harcumner@
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    //stexov toxum enq miayn username u passwordov
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    //stexov bacum enq harcumner@
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(HttpMethod.GET, "/swagger-ui.html/**", "/swagger-resources/**","/user/for-all/**",
                        "/user","/items/**","/address/**","/brand/**","/category/**","/city/**","/color/**",
                        "/country/**","/state/**")
                .antMatchers(HttpMethod.POST, "/user","/items","/address","/city","/country","/state","/brand",
                        "/category","/color")
                .antMatchers(HttpMethod.PUT, "/user/forgot-password", "/user/change-password")
                .antMatchers(HttpMethod.PATCH, "user/verify**","/user/for-all/**","/address/**","/items",
                        "/brand/**","/category/**","/city/**","/color/**","/state/**");
                //.antMatchers(HttpMethod.GET,"/user/get-all");
    }
}