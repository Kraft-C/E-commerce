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

    // 1. Bean pour l'encodage du mot de passe (Corrige la première erreur)
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            // Restriction des endpoints en fonction du rôle
            .authorizeHttpRequests {
                // 2. CORRECTION : Ajout de "/" pour rendre la page d'accueil publique
                it.requestMatchers(
                    "/", // Page d'accueil (index.html)
                    "/e-commerce",
                    "/e-commerce/register",
                    "/e-commerce/login",
                    "/css/**", "/js/**", "/img/**", "/favicon.ico"
                ).permitAll()

                    // Rôles spécifiques
                    .requestMatchers("/e-commerce/admin/**").hasRole("ADMIN")
                    .requestMatchers("/e-commerce/client/**").hasRole("CLIENT")

                    // Toutes les autres requêtes doivent être authentifiées
                    .anyRequest().authenticated()
            }

            // Configuration du formulaire de connexion
            .formLogin { form: FormLoginConfigurer<HttpSecurity?> ->
                form
                    .loginPage("/e-commerce/login")
                    .defaultSuccessUrl("/e-commerce/profil")
                    .failureUrl("/e-commerce/login?error=true")
                    .permitAll()
            }

            // Configuration du mécanisme de déconnexion
            .logout { logout: LogoutConfigurer<HttpSecurity?> ->
                logout
                    .logoutUrl("/e-commerce/logout")
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