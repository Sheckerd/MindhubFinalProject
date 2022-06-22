package com.PatitosdeHule.eCommerce;

import com.PatitosdeHule.eCommerce.models.ClothesSize;
import com.PatitosdeHule.eCommerce.models.Product;
import com.PatitosdeHule.eCommerce.models.ProductType;
import com.PatitosdeHule.eCommerce.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.sql.SQLOutput;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
		System.out.println("Juegue Caballero!");
	}

	@Bean
	public CommandLineRunner init(ProductService productService){
	return args -> {

		Product productNaruto = new Product(400d, "traje naruto", "naruto set", 20, "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "orange", "naruto theme", "traje", true, ProductType.COSPLAY, ClothesSize.M);
		productService.saveProduct(productNaruto);



	};
	}


}
