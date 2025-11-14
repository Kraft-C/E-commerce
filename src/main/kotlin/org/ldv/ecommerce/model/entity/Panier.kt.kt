package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class `Panier.kt`(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,

    var total: Double
)
``]
</llm-patch>

<llm-patch path="/home/louiscaron/Documents/Projet e-commerce/E-commerce/src/main/kotlin/org/ldv/ecommerce/model/entity/Produit.kt" matcher="BeforeAfter">
Ajout de @Column(nullable = false) sur l’id de Produit
<!--Separator-->
Before:
