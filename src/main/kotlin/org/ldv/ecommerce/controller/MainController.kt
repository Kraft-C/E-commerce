import ch.qos.logback.core.model.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping



@Controller
class MainController {

    /**
     * Page d'accueil.
     */
    @GetMapping("/")
    fun home(): String = "index"

    /**
     * Pages visiteur.
     */
    @GetMapping("/a-propos")
    fun aPropos(): String = "pagesVisiteur/a-propos"

    @GetMapping("/contact")
    fun contact(): String = "pagesVisiteur/contact"

    @GetMapping("/inscription")
    fun inscription(): String = "pagesVisiteur/inscription"

    @GetMapping("/produits")
    fun produits(): String = "pagesVisiteur/produits"

    @GetMapping("/rgpd")
    fun rgpd(): String = "pagesVisiteur/rgpd"

    @GetMapping("/cartes")
    fun getCartes(model: Model, produitRepository: Any): String {
        val produits = produitRepository.findAll()
        model.addAttribute("produits", produits)
        return "cartes" // cartes.html
    }

}

private fun Model.addAttribute(string: String, produits: Any) {}

private fun Any.findAll() {
    TODO("Not yet implemented")
}

