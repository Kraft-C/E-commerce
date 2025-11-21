package org.ldv.ecommerce.controller

import ch.qos.logback.core.model.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    // L'URL d'accueil est maintenant publique grâce à SecurityConfig
    @GetMapping("/")
    fun home(): String = "index"

    // 💡 CORRECTION : Ajout de la méthode pour afficher le template de connexion
    // Suppose que login.html se trouve dans src/main/resources/templates/pagesVisiteur/login.html
    @GetMapping("/e-commerce/login")
    fun login(): String {
        return "pagesVisiteur/login"
    }

    // --- Autres pages Visiteur ---
    @GetMapping("/a-propos")
    fun aPropos(): String = "pagesVisiteur/a-propos"
    // ... (autres méthodes de contrôleur)

    @GetMapping("/cartes")
    fun getCartes(model: Model, produitRepository: Any): String {
        // ...
        return "cartes"
    }
}

// Nettoyage des fonctions d'extension temporaires
private fun Model.addAttribute(string: String, produits: Any) {}
private fun Any.findAll() {
    // TODO("Not yet implemented")
}