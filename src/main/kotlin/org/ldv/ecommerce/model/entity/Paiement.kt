package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Paiement(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var montant: Double,
    var datePaiement: LocalDate,

    @OneToOne
    @JoinColumn(name = "commande_id")
    var commande: Commande? = null
)
