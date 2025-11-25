package org.ldv.ecommerce.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableMethodSecurity
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it.requestMatchers(
                    "/",
                    "/e-commerce",
                    "/e-commerce/register",
                    "/e-commerce/login",
                    "/css/**", "/js/**", "/img/**", "/favicon.ico"
                ).permitAll()
                    .requestMatchers("/e-commerce/admin/**").hasRole("ADMIN")
                    .requestMatchers("/e-commerce/client/**").hasRole("CLIENT")
                    .anyRequest().authenticated()
            }
            .formLogin {
                it
                    .loginPage("/e-commerce/login")
                    .loginProcessingUrl("/e-commerce/login")
                    .defaultSuccessUrl("/", true) // redirection vers index.html
                    .failureUrl("/e-commerce/login?error=true")
                    .permitAll()
            }



            .logout {
                it.logoutUrl("/e-commerce/logout")
                    .logoutSuccessUrl("/e-commerce/login?logout")
                    .permitAll()
            }

        return http.build()
    }

    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }
}


