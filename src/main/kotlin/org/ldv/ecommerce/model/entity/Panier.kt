package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
data class Panier(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var total: Double = 0.0,

    @OneToOne
    @JoinColumn(name = "client_id")
    var client: Client? = null,

    @OneToMany(mappedBy = "panier", cascade = [CascadeType.ALL])
    var lignes: MutableList<LignePanier> = mutableListOf()
)
