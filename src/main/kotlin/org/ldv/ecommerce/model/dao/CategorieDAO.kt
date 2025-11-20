package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Categorie
import org.springframework.data.jpa.repository.JpaRepository

interface CategorieDAO : JpaRepository<Categorie, Long> {
    fun findByNom(nom: String): Categorie?
}
