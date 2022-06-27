package com.PatitosdeHule.eCommerce.services;

import com.PatitosdeHule.eCommerce.DTOs.ProductListDTO;
import com.PatitosdeHule.eCommerce.models.ProductList;

import java.util.Set;

public interface ProductListService {

    void saveProductList (ProductList productList);
    Set<ProductListDTO> getProductListDTOs();
}
