package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Categorie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,
    var nom: String
)
