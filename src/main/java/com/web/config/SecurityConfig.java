package com.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * Created by KimYJ on 2017-09-12.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/login/**",  "/css/**", "/images/**", "/js/**", "/console/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .headers().frameOptions().disable()
            .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
            .and()
                .formLogin()
                .loginPage("/login")
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("SESSION")
                .invalidateHttpSession(true)
            .and()
                .csrf().disable();
    }
}