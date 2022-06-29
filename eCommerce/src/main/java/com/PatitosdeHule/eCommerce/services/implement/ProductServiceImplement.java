package com.PatitosdeHule.eCommerce.services.implement;


import com.PatitosdeHule.eCommerce.DTOs.ClothesDTO;
import com.PatitosdeHule.eCommerce.DTOs.CosplayDTO;
import com.PatitosdeHule.eCommerce.DTOs.ProductDTO;
import com.PatitosdeHule.eCommerce.models.Product;
import com.PatitosdeHule.eCommerce.models.ProductType;
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
        public Set<Product> getProducts() {
            return productRepository.findAll().stream().filter(Product::isEnabled).collect(Collectors.toSet());
        }



    @Override
    public Set<ProductDTO> getProductsDTO() {
        return productRepository.findAll().stream().filter(Product::isEnabled).map(ProductDTO::new).collect(Collectors.toSet());

    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Set<ClothesDTO> getClothesDTO() {
        return productRepository.findAll().stream().filter(product -> product.getProductType() == ProductType.CLOTHES && product.isEnabled()).map(ClothesDTO::new).collect(Collectors.toSet());
    }

    @Override
    public Set<CosplayDTO> getCosplayDTO() {
        return productRepository.findAll().stream().filter(product -> product.getProductType() == ProductType.COSPLAY && product.isEnabled()).map(CosplayDTO::new).collect(Collectors.toSet());
    }



    @Override
    public ProductDTO getProductById(long id) {

        return new ProductDTO(productRepository.findById(id).orElse(null));
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }




}
