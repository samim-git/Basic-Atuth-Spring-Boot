package com.hs.basicauth.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    final BasicAuthEntryPoint basicAuthEntryPoint;

    public SecurityConfig(BasicAuthEntryPoint basicAuthEntryPoint) {
        this.basicAuthEntryPoint = basicAuthEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().and().authorizeRequests().anyRequest().authenticated();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("samim")
                .password(getPasswordEncoder().encode("samimjan"))
                .authorities("ROLE_USER");
    }


    @Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(5);
    }
}
