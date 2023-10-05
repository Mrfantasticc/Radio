package com.india.radio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {



    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**")
                .permitAll()
                .requestMatchers("/css/**" , "/js/**","/img/**","/channelImages/**","/","/userTemplates/home")
                .permitAll()
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()

                .and()
                .formLogin();

        return httpSecurity.build();
    }



    @Bean
    public UserDetailsService getUserDetailsService(){

        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return daoAuthenticationProvider;
    }


}
