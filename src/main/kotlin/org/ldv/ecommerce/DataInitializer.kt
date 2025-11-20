package org.ldv.ecommerce.service

import org.apache.poi.ss.usermodel.WorkbookFactory
import org.ldv.ecommerce.model.entity.Produit
import org.ldv.ecommerce.model.entity.Categorie
import org.ldv.ecommerce.model.repository.ProduitRepository
import org.ldv.ecommerce.model.repository.CategorieRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.io.File

@Component
class DataInitializer(
    private val produitRepository: ProduitRepository,
    private val categorieRepository: CategorieRepository
) : CommandLineRunner {

        override fun run(vararg args: String) {
        // Vérifie si la base contient déjà des produits
        if (produitRepository.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données depuis Excel...")

        // Charger le fichier Excel
        val file = File("src/main/resources/inventaire.xlsx") // ton chemin
        val workbook = WorkbookFactory.create(file)
        val sheet = workbook.getSheetAt(0)

        // Crée une catégorie "Cartes à l’unité" si elle n'existe pas
        val categorie = categorieRepository.findByNom("Cartes à l’unité")
            ?: categorieRepository.save(Categorie(id = null, nom = "Cartes à l’unité"))

        // Parcours les lignes du fichier Excel (en sautant l'entête)
        sheet.drop(1).forEach { row ->
            val nom = row.getCell(0).stringCellValue
            val type = row.getCell(1).stringCellValue
            val extension = row.getCell(2).stringCellValue
            val prix = row.getCell(4)?.numericCellValue ?: 0.0
            val stock = row.getCell(5)?.numericCellValue?.toInt() ?: 0

            if (stock > 0) {
                val produit = Produit(
                    id = null,
                    nom = nom,
                    type = type,
                    prix = prix,
                    description = "Extension: $extension",
                )
                produitRepository.save(produit)
            }
        }

        workbook.close()
        println("✅ Import depuis Excel terminé : ${produitRepository.count()} produits insérés.")
    }
}
