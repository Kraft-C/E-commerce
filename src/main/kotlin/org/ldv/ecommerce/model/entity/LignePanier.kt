package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class LignePanier(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var quantite: Int,
    var prixLigne: Double
)
