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

    //close all requests
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

    //open requests for users
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    // open requests
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(HttpMethod.GET, "/swagger-ui.html/**", "/swagger-resources/**", "/user/for-all/**",
                        "/user", "/items/**", "/address/**", "/brand/**", "/category/**", "/city/**", "/color/**",
                        "/country/**", "/state/**", "/basket/**", "/payment_log/**", "/user_balance/**", "/user_items/**")


                .antMatchers(HttpMethod.POST, "/user", "/items", "/address", "/city", "/country", "/state", "/brand",
                        "/category", "/color", "/user/for-all/**", "/basket/**", "/payment_log/**", "/user_balance/**"
                        , "/user_items/**")


                .antMatchers(HttpMethod.PUT, "/user/forgot-password", "/user/change-password")


                .antMatchers(HttpMethod.PATCH, "user/verify**", "/user/for-all/**", "/address/**", "/items/**",
                        "/brand/**", "/category/**", "/city/**", "/color/**", "/state/**", "/country/**", "/basket/**",
                        "/payment_log/**", "/user_balance/**", "/user_items/**");
        //.antMatchers(HttpMethod.GET,"/user/get-all");
    }
}


