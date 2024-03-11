package com.eslam.taskManger.security;

import com.eslam.taskManger.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService service)
    {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(service);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationSuccessHandler customAuthenticationSuccessHandler) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers("/").hasRole("USER")
                        .requestMatchers("/tasks").hasRole("USER")
                        .requestMatchers("/task/**").hasRole("USER")
                        .requestMatchers("/dashboard").hasRole("ADMIN")
                        .requestMatchers("/add-task").hasRole("USER")
                        .requestMatchers("/register/**").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form.loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .successHandler(customAuthenticationSuccessHandler)
                        .permitAll()
        ).logout(logout -> logout.permitAll())
         .exceptionHandling(configurer ->
                 configurer.accessDeniedPage("/access-denied")
         );
        return http.build();
    }
}
