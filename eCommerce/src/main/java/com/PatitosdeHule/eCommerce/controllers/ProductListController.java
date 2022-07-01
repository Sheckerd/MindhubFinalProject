package com.PatitosdeHule.eCommerce.controllers;

import com.PatitosdeHule.eCommerce.DTOs.ProductListDTO;
import com.PatitosdeHule.eCommerce.services.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ProductListController {

    @Autowired
    ProductListService productListService;


    @GetMapping("/productlist")
    public Set<ProductListDTO> getArticleDTOSet(){
        return productListService.getProductListDTOs(); //ヾ(≧▽≦*)o

    }



}