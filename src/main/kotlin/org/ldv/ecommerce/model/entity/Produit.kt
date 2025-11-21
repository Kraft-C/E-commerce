package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
data class Produit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,                  // Nom de la carte
    var extention: String,
    var prix: Double,                 // Prix
    var stock: Int,                   // Stock dispo
    var image: String,                // Nom du fichier image
    var description: String? = null,

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    var categorie: Categorie? = null, // Catégorie (Cartes à l'unité)

    @OneToMany(mappedBy = "produit")
    var avis: MutableList<Avis> = mutableListOf(),

    @OneToMany(mappedBy = "produit")
    var lignesPanier: MutableList<LignePanier> = mutableListOf()
)
