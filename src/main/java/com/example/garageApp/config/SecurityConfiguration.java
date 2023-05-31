package com.example.garageApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.StaticHeadersWriter;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    private Environment env;
    //----------------------------------------------------------------------
    // @Bean
    // public BCryptPasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     
        http.httpBasic()
        .and().authorizeHttpRequests()
        .requestMatchers("/", "/home", "/login").permitAll()
        .anyRequest().authenticated()
        .and().headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin","http://localhost:"+this.env.getProperty("server.port")))
        .and().headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers","*"))
        .and().headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age","300"))
        .and().headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods","GET,POST,DELETE,HEAD,OPTIONS"))
        .and().headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Credentials","true"))
        .and().cors().and().csrf().disable();
        // .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
 
        return http.build();
    }


    //----------------------------------------------------------------------
    // @Bean
    // public AuthenticationManager authenticationManager(
    //         AuthenticationConfiguration authenticationConfiguration) throws Exception { 
    //     return authenticationConfiguration.getAuthenticationManager();
    // }

}