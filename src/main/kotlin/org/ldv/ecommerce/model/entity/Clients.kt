package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
data class Client(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,

    @OneToOne(mappedBy = "client", cascade = [CascadeType.ALL])
    var panier: Panier? = null,

    @OneToMany(mappedBy = "client")
    var commandes: MutableList<Commande> = mutableListOf(),

    @OneToMany(mappedBy = "client")
    var avis: MutableList<Avis> = mutableListOf()
)
