package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager user(){
        return new InMemoryUserDetailsManager(
                User.withUsername("khadija")
                        .password("{noop}password")
                        .authorities("read")
                        .build()
        );
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeHttpRequests().anyRequest().authenticated()
//                .requestMatchers( "/login").permitAll()
                .and()
//                .authorizeHttpRequests()
//            .requestMatchers( "/sign-in").permitAll()
//                .requestMatchers("/users").hasAnyAuthority("ADMIN")
//                .and()
//            .requestMatchers( "/users").permitAll()

//            .requestMatchers( "/reset").permitAll()
//                .authorizeHttpRequests()
//                .anyRequest().hasAnyAuthority("ADMIN")
//                .and()
//                .formLogin(
//                        form -> form
//                                .loginPage("/login")
////                                .loginProcessingUrl("/sign-in")
//                                .defaultSuccessUrl("/users")
//                                .permitAll()
//                ).logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .permitAll()
//
//                )
                .httpBasic();

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}

