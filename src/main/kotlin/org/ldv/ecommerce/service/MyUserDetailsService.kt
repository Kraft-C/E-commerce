import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(private val utilisateurDAO: UtilisateurDAO) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {

        val utilisateur = utilisateurDAO.findByEmail(username)
            ?: throw UsernameNotFoundException("User not found")

        val leRole = utilisateur.role?.nom

        return org.springframework.security.core.userdetails.User
            .withUsername(utilisateur.email)
            .password(utilisateur.mdp)
            .roles(leRole)
            .build()
    }
}
