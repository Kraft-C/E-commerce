package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Commande(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    var date: java.time.LocalDate,
    var statut: String,
    var montantTotal: Double
)
