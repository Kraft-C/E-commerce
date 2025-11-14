package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Produit(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var nom: String,
    var type: String,
    var prix: Double,
    var description: String
)
