package com.example.DevConnect.configration

import org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig{
    @Bean
    fun configure(http: HttpSecurity): WebSecurityCustomizer {
        return WebSecurityCustomizer { web ->
            web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/h2-console/**")
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers("/login", "/signup", "/h2-console").permitAll()
                    .anyRequest().authenticated()
            }
            .formLogin { form ->
                form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            }
            .logout { logout ->
                logout.permitAll()
            }
        return http.build()
    }
}