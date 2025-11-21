package org.ldv.ecommerce.controller

import ch.qos.logback.core.model.Model
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController {


    // L'URL d'accueil est maintenant publique grâce à SecurityConfig
    @GetMapping("/")
    fun home(): String = "index"


    @GetMapping("/e-commerce/login")
    fun login(@RequestParam error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
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