package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
data class Produit(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,
    var type: String,
    var prix: Double,
    var description: String,

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    var categorie: Categorie? = null,

    @OneToMany(mappedBy = "produit")
    var avis: MutableList<Avis> = mutableListOf(),

    @OneToMany(mappedBy = "produit")
    var lignesPanier: MutableList<LignePanier> = mutableListOf()
)
