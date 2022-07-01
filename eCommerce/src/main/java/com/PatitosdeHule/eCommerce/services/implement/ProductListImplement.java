package com.PatitosdeHule.eCommerce.services.implement;

import com.PatitosdeHule.eCommerce.DTOs.ProductListDTO;
import com.PatitosdeHule.eCommerce.models.ProductList;
import com.PatitosdeHule.eCommerce.repositories.ProductListRepository;
import com.PatitosdeHule.eCommerce.services.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductListImplement implements ProductListService {


    @Autowired
    private ProductListRepository productListRepository;

    @Override
    public void saveProductList(ProductList productList) {
        productListRepository.save(productList);
    }

    @Override
    public Set<ProductListDTO> getProductListDTOs() {
        return productListRepository.findAll().stream().map(ProductListDTO::new).collect(Collectors.toSet());
    }


}
