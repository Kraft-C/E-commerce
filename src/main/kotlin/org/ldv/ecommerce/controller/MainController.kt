package org.ldv.ecommerce.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController {

    // Page d'accueil
    @GetMapping("/")
    fun home(): String = "index"

    // Page de connexion
    @GetMapping("/e-commerce/login")
    fun login(@RequestParam(required = false) error: String?, model: Model): String {
        // Passe un attribut "error" au template si la connexion échoue
        model.addAttribute("error", error != null)
        return "pagesVisiteur/login"
    }

    // Autres pages visiteur
    @GetMapping("/a-propos")
    fun aPropos(): String = "pagesVisiteur/a-propos"

    @GetMapping("/cartes")
    fun getCartes(model: Model): String {
        // Ici tu peux ajouter les produits si besoin
        return "cartes"
    }
}
