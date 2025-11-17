package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Administrateur
import org.springframework.data.jpa.repository.JpaRepository

interface AdministrateurDAO : JpaRepository<Administrateur, Long>
