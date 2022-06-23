package com.PatitosdeHule.eCommerce.controllers;


import com.PatitosdeHule.eCommerce.DTOs.ClothesDTO;
import com.PatitosdeHule.eCommerce.DTOs.CosplayDTO;
import com.PatitosdeHule.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

   @GetMapping("/products/clothes")
    public Set<ClothesDTO> getClothesDTOs(){
       return productService.getClothesDTO();
   }

    @GetMapping("/products/cosplay")
    public Set<CosplayDTO> getCosplayDTOs(){
        return productService.getCosplayDTO();
    }



}
