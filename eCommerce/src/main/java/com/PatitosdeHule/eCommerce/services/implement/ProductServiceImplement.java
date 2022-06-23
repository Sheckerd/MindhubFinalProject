package com.PatitosdeHule.eCommerce.services.implement;


import com.PatitosdeHule.eCommerce.DTOs.ClothesDTO;
import com.PatitosdeHule.eCommerce.models.Product;
import com.PatitosdeHule.eCommerce.repositories.ProductRepository;
import com.PatitosdeHule.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Set<ClothesDTO> getProductsDTO() {
        return productRepository.findAll().stream().map(product -> new ClothesDTO(product)).collect(Collectors.toSet());
    }


}
