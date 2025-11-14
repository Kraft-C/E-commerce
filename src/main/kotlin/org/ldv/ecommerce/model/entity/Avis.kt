package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Avis(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var texte: String,
    var note: Int,
    var dateAvis: java.time.LocalDate
)
