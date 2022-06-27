package com.PatitosdeHule.eCommerce.controllers;


import com.PatitosdeHule.eCommerce.DTOs.*;
import com.PatitosdeHule.eCommerce.models.*;
import com.PatitosdeHule.eCommerce.services.ClientService;
import com.PatitosdeHule.eCommerce.services.InvoiceService;
import com.PatitosdeHule.eCommerce.services.ProductService;
import com.PatitosdeHule.eCommerce.services.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    ClientService clientService;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    ProductListService productListService;

    @GetMapping("/products")
    public Set<ProductDTO> getProductsDTO() {
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
    public ProductDTO getProduct(@PathVariable long id) {

        return productService.getProductById(id);

    }

    @PostMapping("/products/cosplay")
    public ResponseEntity<Object> createProductsCosplay(Authentication authentication, @RequestBody CreateCosplayDTO createCosplayDTO) {

        Client client = clientService.getClientCurrent(authentication);
        Set<Product> productList = productService.getProducts();

        if (!client.getEmail().contains("@orgm.com")) {
            return new ResponseEntity<>("Only administrators have permission", HttpStatus.FORBIDDEN);
        } //Si no es admin, no puede crear.

        if (createCosplayDTO.getName().isEmpty() || createCosplayDTO.getDescription().isEmpty()) {
            return new ResponseEntity<>("Missing data: name or description needed", HttpStatus.FORBIDDEN);
        } //Si nombre y descripcion estan vacíos.

        if (createCosplayDTO.getImageURL_front().isEmpty()) {
            return new ResponseEntity<>("Missing data: Image URL needed", HttpStatus.FORBIDDEN);
        } // Si falta imagen.

        if (createCosplayDTO.getAnimeTheme().isEmpty()) {
            return new ResponseEntity<>("Missing data: AnimeTheme needed", HttpStatus.FORBIDDEN);
        } // Si falta datos de la temática.

        if (!createCosplayDTO.getProductType().equals(ProductType.COSPLAY)) {
            return new ResponseEntity<>("Error: Product type doesn't match", HttpStatus.FORBIDDEN);
        } // Si el tipo de producto no coincide.

//         if (!createCosplayDTO.getClothesSize().equals(ClothesSize.S) && !createCosplayDTO.getClothesSize().equals(ClothesSize.M) && !createCosplayDTO.getClothesSize().equals(ClothesSize.L) && !createCosplayDTO.getClothesSize().equals(ClothesSize.XL) && !createCosplayDTO.getClothesSize().equals(ClothesSize.XXL)) {
//             return new ResponseEntity<>("Error: missing product size", HttpStatus.FORBIDDEN);
//         } // Si falta talle del producto.

        if (createCosplayDTO.getSize().isEmpty()) {
            return new ResponseEntity<>("Missing data: Size needed", HttpStatus.FORBIDDEN);
        }

        if (createCosplayDTO.getStock() <= 0) {
            return new ResponseEntity<>("Error: Product stock is 0 or less", HttpStatus.FORBIDDEN);
        } // Si el stock no está definido.

        if (createCosplayDTO.getPrice() <= 0) {
            return new ResponseEntity<>("Error: Product price is 0 or less", HttpStatus.FORBIDDEN);
        } // Si el tipo de producto no coincide.

        if (productList.stream().map(Product::getName).collect(Collectors.toSet()).contains(createCosplayDTO.getName())) {

            return new ResponseEntity<>("Error: Product already exist", HttpStatus.FORBIDDEN);
        }

        Product newCosplay = new Product(createCosplayDTO.getName(), createCosplayDTO.getDescription(), createCosplayDTO.getImageURL_front(), createCosplayDTO.getAnimeTheme(), createCosplayDTO.isLimitedEdition(), createCosplayDTO.getProductType(), createCosplayDTO.getSize(), createCosplayDTO.getStock(), createCosplayDTO.getPrice());
        productService.saveProduct(newCosplay);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/products/clothes")
    public ResponseEntity<Object> createProductsClothes(Authentication authentication, @RequestBody CreateClothesDTO createClothesDTO) {

        Client client = clientService.getClientCurrent(authentication);
        Set<Product> productList = productService.getProducts();


        if (!client.getEmail().contains("@orgm.com")) {
            return new ResponseEntity<>("Only administrators have permission", HttpStatus.FORBIDDEN);
        } //Si no es admin, no puede crear.

        if (createClothesDTO.getName().isEmpty() || createClothesDTO.getDescription().isEmpty() || createClothesDTO.getColors().isEmpty()) {
            return new ResponseEntity<>("Missing data: name or description needed", HttpStatus.FORBIDDEN);
        } //Si nombre y descripcion estan vacíos.

        if (createClothesDTO.getColors().isEmpty()) {
            return new ResponseEntity<>("Missing data: color needed", HttpStatus.FORBIDDEN);
        }

        if (createClothesDTO.getImageURL_front().isEmpty() || createClothesDTO.getImageURL_back().isEmpty()) {
            return new ResponseEntity<>("Missing data: Image URL needed", HttpStatus.FORBIDDEN);
        } // Si falta imagen front o back.

        if (createClothesDTO.getAnimeTheme().isEmpty()) {
            return new ResponseEntity<>("Missing data: AnimeTheme needed", HttpStatus.FORBIDDEN);
        } // Si falta datos de la temática.

        if (!createClothesDTO.getProductType().equals(ProductType.CLOTHES)) {
            return new ResponseEntity<>("Error: Product type doesn't match", HttpStatus.FORBIDDEN);
        } // Si el tipo de producto no coincide.

//         if (!createClothesDTO.getClothesSize().equals(ClothesSize.S) && !createClothesDTO.getClothesSize().equals(ClothesSize.M) && !createClothesDTO.getClothesSize().equals(ClothesSize.L) && !createClothesDTO.getClothesSize().equals(ClothesSize.XL) && !createClothesDTO.getClothesSize().equals(ClothesSize.XXL)) {
//             return new ResponseEntity<>("Error: missing product size", HttpStatus.FORBIDDEN);
//         } // Si falta talle del producto.


        if (createClothesDTO.getSize().isEmpty()) {
            return new ResponseEntity<>("Missing data: Size needed", HttpStatus.FORBIDDEN);
        }

        if (createClothesDTO.getStock() <= 0) {
            return new ResponseEntity<>("Error: Product stock is 0 or less", HttpStatus.FORBIDDEN);
        } // Si el stock no está definido.

        if (createClothesDTO.getPrice() <= 0) {
            return new ResponseEntity<>("Error: Product price is 0 or less", HttpStatus.FORBIDDEN);
        } // Si el tipo de producto no coincide.

        if (productList.stream().map(Product::getName).collect(Collectors.toSet()).contains(createClothesDTO.getName())) {

            return new ResponseEntity<>("Error: Product already exist", HttpStatus.FORBIDDEN);
        }


        Product newClothes = new Product(createClothesDTO.getName(), createClothesDTO.getColors(), createClothesDTO.getDescription(), createClothesDTO.getImageURL_front(), createClothesDTO.getImageURL_back(), createClothesDTO.getAnimeTheme(), createClothesDTO.getClothesType(), createClothesDTO.isLimitedEdition(), createClothesDTO.getProductType(), createClothesDTO.getSize(), createClothesDTO.getStock(), createClothesDTO.getPrice());
        productService.saveProduct(newClothes);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Transactional
    @PatchMapping("/products")
    public ResponseEntity<Object> addProductList(@RequestBody ProductListAppDTO productListAppDTO) {

        Product product = productService.getProduct(productListAppDTO.getId());

        int stockUpdate = product.getStock() - productListAppDTO.getQuantity();
        product.setStock(stockUpdate);

        Invoice invoice = invoiceService.getLastInvoice();

        ProductList productList = new ProductList(product, productListAppDTO.getQuantity(), product.getPrice(), invoice);
        productListService.saveProductList(productList);

        invoice.addArticles(productList);
        invoice.setTotal_value(invoice.getTotal_value() + product.getPrice() * productListAppDTO.getQuantity());
        invoiceService.saveInvoices(invoice);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PatchMapping("/products/status")
    public ResponseEntity<Object> changeProductStatus(Authentication authentication, @RequestParam long id) {

        Client client = clientService.getClientCurrent(authentication);
        Product product = productService.getProduct(id);

        if (!client.getEmail().contains("@orgm.com")) {
            return new ResponseEntity<>("Only administrators have permission", HttpStatus.FORBIDDEN);
        } //Si no es admin, no puede crear.

        if (product == null) {
            return new ResponseEntity<>("Error: product doesn't exist", HttpStatus.FORBIDDEN);
        }

        if (product.isEnabled()) {
            return new ResponseEntity<>("Error: product is already disabled", HttpStatus.FORBIDDEN);
        }

        if (product.getStock() > 0) {
            return new ResponseEntity<>("Error: product has stock", HttpStatus.FORBIDDEN);

        }

        product.setEnabled(false);
        productService.saveProduct(product);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PatchMapping
    public ResponseEntity<Object> changeStockProduct(Authentication authentication, @RequestParam long id) {

        Client client = clientService.getClientCurrent(authentication);
        Product product = productService.getProduct(id);

        if (!client.getEmail().contains("@orgm.com")) {
            return new ResponseEntity<>("Only administrators have permission", HttpStatus.FORBIDDEN);
        } //Si no es admin, no puede crear.

        if (product == null) {
            return new ResponseEntity<>("Error: product doesn't exist", HttpStatus.FORBIDDEN);
        }


        if (product.getStock() < 0) {
            return new ResponseEntity<>("Error: stock can't be less than 0", HttpStatus.FORBIDDEN);

        }


        product.setStock(product.getStock());
        productService.saveProduct(product);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
