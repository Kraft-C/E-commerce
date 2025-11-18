package org.ldv.ecommerce

import org.ldv.ecommerce.model.dao.ProduitDAO
import org.ldv.ecommerce.model.entity.Produit
import org.springframework.boot.CommandLineRunner
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets

@Component
class DataInitializer(
    private val produitDAO: ProduitDAO
) : CommandLineRunner {

    override fun run(vararg args: String) {
        try {
            // Vérifie si la base contient déjà des produits
            if (produitDAO.count() > 0L) {
                println("ℹ️ Données déjà présentes, initialisation ignorée.")
                return
            }

            println("🚀 Initialisation des données depuis inventaire.csv...")

            // Lecture du fichier CSV depuis le classpath
            val resource = ClassPathResource("static/Data/inventaire.csv")
            if (!resource.exists()) {
                println("⚠️ Fichier inventaire.csv introuvable dans resources/static/Data, initialisation ignorée.")
                return
            }

            resource.inputStream.bufferedReader(StandardCharsets.UTF_8).useLines { lines ->
                lines.drop(1).forEach { line ->
                    // Supporte séparateur ; ou ,
                    val tokens = line.split(';', ',').map { it.trim() }
                    if (tokens.size < 5) return@forEach

                    val nom = tokens[0]
                    val type = tokens[1]
                    val extension = tokens[2]
                    val prix = tokens.getOrNull(4)?.replace(",", ".")?.toDoubleOrNull() ?: 0.0
                    val stock = tokens.getOrNull(5)?.toIntOrNull() ?: 0

                    if (stock > 0) {
                        val produit = Produit(
                            id = null,
                            nom = nom,
                            type = type,
                            prix = prix,
                            description = "Extension: $extension",
                        )
                        produitDAO.save(produit)
                    }
                }
            }

            println("✅ Import terminé : ${produitDAO.count()} produits insérés.")
        } catch (ex: Exception) {
            println("❌ Erreur lors de l'initialisation des données: ${ex.message}")
        }
    }
}
