package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Utilisateur(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    var nom: String,
    var email: String,
    var motDePasse: String
)
