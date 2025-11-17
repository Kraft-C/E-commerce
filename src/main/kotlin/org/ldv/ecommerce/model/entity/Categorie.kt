package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
data class Categorie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,

    @OneToMany(mappedBy = "categorie")
    var produits: MutableList<Produit> = mutableListOf()
)
