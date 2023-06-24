package com.project.shopping_mall.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .formLogin()
                .loginPage("/auth/login-form")
                .loginProcessingUrl("/process_login")
                .failureUrl("/auths/login-form?error")
                .and()
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll();

        return httpSecurity.build();
    }


    @Bean
    public UserDetailsManager userDetailsManager() {

        UserDetails userDetails =
                User.withDefaultPasswordEncoder()
                        .username("test1234@gmail.com")
                        .password("test1234")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

}






