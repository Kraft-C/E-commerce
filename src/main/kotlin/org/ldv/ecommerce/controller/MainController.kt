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
}

