package com.example.votreProjet.controller;

import org.ldv.ecommerce.model.dao.CategorieDAO
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping;


@Controller
class AdminController (
    val categorieDAO: CategorieDAO
)

@Controller
public class AdminControllerController {


    @GetMapping("/E-commerce/admin/")
    fun adminCategories() = "admin"

    @GetMapping("/e-commerce/admin/categories")
    fun index(model: Model):String {
        val categorieDAO = null
        val categories = categorieDAO.findAll()
        model.addAttribute("categories", categories)
        return "pageAdmin/categorie/index"
    }

}
private fun Nothing?.findAll() {
    TODO("Not yet implemented")
}
