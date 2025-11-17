package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Livraison
import org.springframework.data.jpa.repository.JpaRepository

interface LivraisonDAO : JpaRepository<Livraison, Long>
