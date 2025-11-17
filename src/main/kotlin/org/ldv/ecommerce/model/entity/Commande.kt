package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Commande(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var date: LocalDate,
    var statut: String,
    var montantTotal: Double,

    @ManyToOne
    @JoinColumn(name = "client_id")
    var client: Client? = null,

    @OneToOne(mappedBy = "commande", cascade = [CascadeType.ALL])
    var paiement: Paiement? = null,

    @OneToOne(mappedBy = "commande", cascade = [CascadeType.ALL])
    var livraison: Livraison? = null
)
