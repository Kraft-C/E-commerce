package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.LignePanier
import org.springframework.data.jpa.repository.JpaRepository

interface LignePanierDAO : JpaRepository<LignePanier, Long>
