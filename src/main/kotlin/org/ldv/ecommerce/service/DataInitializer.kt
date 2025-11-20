package org.ldv.ecommerce.service

import org.ldv.ecommerce.model.dao.CategorieDAO
import org.ldv.ecommerce.model.dao.ProduitDAO
import org.ldv.ecommerce.model.dao.RoleDAO
import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.ldv.ecommerce.model.entity.Categorie
import org.ldv.ecommerce.model.entity.Produit
import org.ldv.ecommerce.model.entity.Role
import org.ldv.ecommerce.model.entity.Utilisateur
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val produitDAO: ProduitDAO,
    private val categorieDAO: CategorieDAO,
    private val roleDAO: RoleDAO,
    private val utilisateurDAO: UtilisateurDAO,
    private val passwordEncoder: PasswordEncoder,
) : CommandLineRunner {

    override fun run(vararg args: String) {
        if (produitDAO.count() > 0L) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données...")

        // Catégorie par défaut
        val defaultCategorieName = "Cartes à l'unité"
        val categorie = categorieDAO.findByNom(defaultCategorieName)
            ?: categorieDAO.save(Categorie(id = null, nom = defaultCategorieName))

        // Produits
        val produits = listOf(
            Produit(null, "Ho-Oh EX", "DRI", 1.0, 1, "Ho-Oh EX"),
            Produit(null, "Méga Absol EX", "MEG", 1.0, 1, "Méga Absol EX"),
            Produit(null, "Méga Élecsprint EX", "MEG", 1.0, 1, "Méga Élecsprint EX"),
            Produit(null, "Méga Mysdibule EX", "MEG", 1.0, 1, "Méga Mysdibule EX"),
            Produit(null, "Zoroark EX de N", "JTG", 4.0,  1, "Zoroark EX de N"),
            Produit(null, "Méga Latias EX", "MEG", 1.0,  1, "Méga Latias EX"),
            Produit(null, "Méga Blizzaroi EX", "MEG", 1.0, 1, "Méga Blizzaroi EX"),
            Produit(null, "Roucarnage V", "LOR", 1.0, 1, "Roucarnage V"),
            Produit(null, "Garde-de-Fer EX", "PAR", 1.0, 1, "Garde-de-Fer EX")
        )

        produits.forEach { produitDAO.save(it) }

        // Roles
        val roleAdmin = roleDAO.findByNom("ADMIN") ?: roleDAO.save(Role(nom = "ADMIN"))
        val roleClient = roleDAO.findByNom("CLIENT") ?: roleDAO.save(Role(nom = "CLIENT"))

        // Utilisateurs
        val admin = Utilisateur(
            id = null,
            nom = "Super",
            prenom = "Admin",
            email = "admin@admin.com",
            mdp = passwordEncoder.encode("admin123"),
            role = roleAdmin as Role?
        )

        val client = Utilisateur(
            id = null,
            nom = "Jean",
            prenom = "Client",
            email = "client@client.com",
            mdp = passwordEncoder.encode("client123"),
            role = roleClient as Role?
        )

        utilisateurDAO.saveAll(listOf(admin, client))

        println("✅ Import terminé : ${produitDAO.count()} produits, ${roleDAO.count()} roles, ${utilisateurDAO.count()} utilisateurs")
    }
}
