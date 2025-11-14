package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Livraison(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    var dateLivraison: java.time.LocalDate,
    var statutLivraison: String
)
