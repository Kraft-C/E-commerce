package com.example.votreProjet.controller;

import org.ldv.ecommerce.model.dao.CategorieDAO
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
class AdminController (
    val categorieDAO: CategorieDAO
)


@Controller
public class AdminControllerController {

    @GetMapping("/E-commerce/admin/")
    fun adminCategories() = "admin"

}