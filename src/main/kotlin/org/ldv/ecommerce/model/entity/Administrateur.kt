package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Administrateur(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?
)
