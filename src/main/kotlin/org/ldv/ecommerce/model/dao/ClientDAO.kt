package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientDAO : JpaRepository<Client, Long>
