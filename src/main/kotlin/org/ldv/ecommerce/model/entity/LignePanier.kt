package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
data class LignePanier(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var quantite: Int,
    var prixLigne: Double,

    @ManyToOne
    @JoinColumn(name = "panier_id")
    var panier: Panier? = null,

    @ManyToOne
    @JoinColumn(name = "produit_id")
    var produit: Produit? = null
)
