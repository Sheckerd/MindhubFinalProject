package com.PatitosdeHule.eCommerce.services;

import com.PatitosdeHule.eCommerce.DTOs.ProductDTO;
import com.PatitosdeHule.eCommerce.models.Product;

import java.util.Set;

public interface ProductService {

    void saveProduct(Product product);
    Set<ProductDTO> getProductsDTO();
}
