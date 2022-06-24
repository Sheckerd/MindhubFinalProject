package com.PatitosdeHule.eCommerce.services;

import com.PatitosdeHule.eCommerce.DTOs.ClothesDTO;
import com.PatitosdeHule.eCommerce.DTOs.CosplayDTO;
import com.PatitosdeHule.eCommerce.DTOs.ProductDTO;
import com.PatitosdeHule.eCommerce.models.Product;
import com.PatitosdeHule.eCommerce.models.ProductType;

import java.util.Set;

public interface ProductService {

    void saveProduct(Product product);
    Set<ClothesDTO> getClothesDTO();
    Set<CosplayDTO> getCosplayDTO();
    Set<ProductDTO> getProductsDTO();



}
