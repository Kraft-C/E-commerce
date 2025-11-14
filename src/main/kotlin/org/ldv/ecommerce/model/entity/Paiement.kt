package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Paiement(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    var montant: Double,
    var datePaiement: java.time.LocalDate
)
