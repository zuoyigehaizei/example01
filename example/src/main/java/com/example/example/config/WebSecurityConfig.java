package com.example.example.config;

import com.example.example.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //配置需要bean
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //数据库读取用户名密码，暂时有错误
        //auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
        //内存中读取用户名密码
        auth.inMemoryAuthentication().passwordEncoder(new AppPasswordEncoder())
                .withUser("abc").password("abc").roles("ADMIN","USER").and()
                .withUser("sang").password("sang").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().
                loginPage("/login").failureUrl("/login?error").
                permitAll().and().logout().permitAll();
    }
}
