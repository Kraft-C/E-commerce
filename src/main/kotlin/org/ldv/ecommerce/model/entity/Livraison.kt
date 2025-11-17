package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Livraison(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var dateLivraison: LocalDate,
    var statutLivraison: String,

    @OneToOne
    @JoinColumn(name = "commande_id")
    var commande: Commande? = null
)
