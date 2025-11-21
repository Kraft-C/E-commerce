package org.ldv.ecommerce.service

import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MyUserDetailsService(private val utilisateurDAO: UtilisateurDAO) : UserDetailsService {

    @Transactional(readOnly = true) // Bonne pratique pour la lecture
    override fun loadUserByUsername(username: String): UserDetails {

        // 1. Cherche l'utilisateur
        val utilisateur = utilisateurDAO.findByEmail(username)
            ?: throw UsernameNotFoundException("User not found: $username")

        // 2. Récupère le nom du rôle ou utilise "CLIENT" si le rôle est null
        val roleNom = utilisateur.role?.nom ?: "CLIENT"

        // 3. Construit l'objet UserDetails
        return org.springframework.security.core.userdetails.User
            .withUsername(utilisateur.email) // Email utilisé comme username
            .password(utilisateur.mdp) // Le mot de passe HACHÉ
            .roles(roleNom) // Spring ajoute automatiquement le préfixe "ROLE_"
            .build()
    }
}