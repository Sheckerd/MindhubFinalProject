package com.PatitosdeHule.eCommerce.controllers;


import com.PatitosdeHule.eCommerce.DTOs.ClothesDTO;
import com.PatitosdeHule.eCommerce.DTOs.CosplayDTO;
import com.PatitosdeHule.eCommerce.DTOs.ProductDTO;
import com.PatitosdeHule.eCommerce.models.*;
import com.PatitosdeHule.eCommerce.services.ClientService;
import com.PatitosdeHule.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    ClientService clientService;


    @GetMapping("/products")
    public Set<ProductDTO> getProductsDTO(){
        return productService.getProductsDTO();
    }
    @GetMapping("/products/clothes")
    public Set<ClothesDTO> getClothesDTOs() {
        return productService.getClothesDTO();
    }

    @GetMapping("/products/cosplay")
    public Set<CosplayDTO> getCosplayDTOs() {
        return productService.getCosplayDTO();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {

        return productService.getProductById(id);

    }

    @PostMapping("/products/cosplay")
    public ResponseEntity<Object> createProductsCosplay(Authentication authentication, @RequestBody CosplayDTO cosplayDTO) {

        Client client = clientService.getClientCurrent(authentication);

        if (!client.getEmail().contains("@orgm.com")) {
            return new ResponseEntity<>("Only administrators have permission", HttpStatus.FORBIDDEN);
        } //Si no es admin, no puede crear.

        if (cosplayDTO.getName().isEmpty() || cosplayDTO.getDescription().isEmpty()) {
            return new ResponseEntity<>("Missing data: name or description needed", HttpStatus.FORBIDDEN);
        } //Si nombre y descripcion estan vacíos.

        if (cosplayDTO.getImageURL_front().isEmpty()) {
            return new ResponseEntity<>("Missing data: Image URL needed", HttpStatus.FORBIDDEN);
        } // Si falta imagen.

        if (cosplayDTO.getAnimeTheme().isEmpty()) {
            return new ResponseEntity<>("Missing data: AnimeTheme needed", HttpStatus.FORBIDDEN);
        } // Si falta datos de la temática.

        if (!cosplayDTO.getProductType().equals(ProductType.COSPLAY)){
            return new ResponseEntity<>("Error: Product type doesn't match", HttpStatus.FORBIDDEN);
        } // Si el tipo de producto no coincide.

    //    if(!cosplayDTO.getClothesSize().equals(ClothesSize.S) || !cosplayDTO.getClothesSize().equals(ClothesSize.M) || !cosplayDTO.getClothesSize().equals(ClothesSize.L) || !cosplayDTO.getClothesSize().equals(ClothesSize.XL) || !cosplayDTO.getClothesSize().equals(ClothesSize.XXL)){
    //        return new ResponseEntity<>("Error: missing product size", HttpStatus.FORBIDDEN);
     //   } // Si falta talle del producto.

        if (cosplayDTO.getStock() <= 0){
            return new ResponseEntity<>("Error: Product stock is 0 or less", HttpStatus.FORBIDDEN);
        } // Si el stock no está definido.

        if (cosplayDTO.getPrice() <= 0){
            return new ResponseEntity<>("Error: Product price is 0 or less", HttpStatus.FORBIDDEN);
        } // Si el tipo de producto no coincide.

        Product newCosplay = new Product(cosplayDTO.getName(), cosplayDTO.getDescription(), cosplayDTO.getImageURL_front(),cosplayDTO.getAnimeTheme(), cosplayDTO.isLimitedEdition(), cosplayDTO.getProductType(),cosplayDTO.getClothesSize(),cosplayDTO.getStock(), cosplayDTO.getPrice());
        productService.saveProduct(newCosplay);


            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/products/clothes")
    public ResponseEntity<Object> createProductsClothes(Authentication authentication, @RequestBody ClothesDTO clothesDTO) {

        Client client = clientService.getClientCurrent(authentication);

        if (!client.getEmail().contains("@orgm.com")) {
            return new ResponseEntity<>("Only administrators have permission", HttpStatus.FORBIDDEN);
        } //Si no es admin, no puede crear.

        if (clothesDTO.getName().isEmpty() || clothesDTO.getDescription().isEmpty() || clothesDTO.getColors().isEmpty()) {
            return new ResponseEntity<>("Missing data: name or description needed", HttpStatus.FORBIDDEN);
        } //Si nombre y descripcion estan vacíos.

        if (clothesDTO.getImageURL_front().isEmpty() || clothesDTO.getImageURL_back().isEmpty()) {
            return new ResponseEntity<>("Missing data: Image URL needed", HttpStatus.FORBIDDEN);
        } // Si falta imagen front o back.

        if (clothesDTO.getAnimeTheme().isEmpty()) {
            return new ResponseEntity<>("Missing data: AnimeTheme needed", HttpStatus.FORBIDDEN);
        } // Si falta datos de la temática.

        if (!clothesDTO.getProductType().equals(ProductType.CLOTHES)){
            return new ResponseEntity<>("Error: Product type doesn't match", HttpStatus.FORBIDDEN);
        } // Si el tipo de producto no coincide.

//        if(!clothesDTO.getClothesSize().equals(ClothesSize.S) || !clothesDTO.getClothesSize().equals(ClothesSize.M) || !clothesDTO.getClothesSize().equals(ClothesSize.L) || !clothesDTO.getClothesSize().equals(ClothesSize.XL) || !clothesDTO.getClothesSize().equals(ClothesSize.XXL)){
//            return new ResponseEntity<>("Error: missing product size", HttpStatus.FORBIDDEN);
//        } // Si falta talle del producto.

        if (clothesDTO.getStock() <= 0){
            return new ResponseEntity<>("Error: Product stock is 0 or less", HttpStatus.FORBIDDEN);
        } // Si el stock no está definido.

        if (clothesDTO.getPrice() <= 0){
            return new ResponseEntity<>("Error: Product price is 0 or less", HttpStatus.FORBIDDEN);
        } // Si el tipo de producto no coincide.


        Product newClothes = new Product(clothesDTO.getName(), clothesDTO.getColors(), clothesDTO.getDescription(), clothesDTO.getImageURL_front(), clothesDTO.getImageURL_back(), clothesDTO.getAnimeTheme(), clothesDTO.getClothesType(), clothesDTO.isLimitedEdition(), clothesDTO.getProductType(), clothesDTO.getClothesSize(), clothesDTO.getStock(), clothesDTO.getPrice());
        productService.saveProduct(newClothes);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
