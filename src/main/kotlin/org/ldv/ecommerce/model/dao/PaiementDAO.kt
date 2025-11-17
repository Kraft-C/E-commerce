package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Paiement
import org.springframework.data.jpa.repository.JpaRepository

interface PaiementDAO : JpaRepository<Paiement, Long>
