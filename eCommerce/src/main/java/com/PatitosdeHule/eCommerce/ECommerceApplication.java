package com.PatitosdeHule.eCommerce;

import com.PatitosdeHule.eCommerce.models.*;
import com.PatitosdeHule.eCommerce.services.ClientService;
import com.PatitosdeHule.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
		System.out.println("Juegue Caballero!");
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner init(ProductService productService, ClientService clientService){
	return args -> {

		Product cosplayNaruto = new Product("naruto set", "traje naruto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "naruto theme", true, ProductType.COSPLAY, ClothesSize.M,20,400d);
		Product clotheBNHA = new Product("Remera Izuki", "verde/c negro", "Una remera muito delicia mmmmmm", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "BNHA", ClothesType.T_SHIRT, false, ProductType.CLOTHES, ClothesSize.S, 17, 250);
		productService.saveProduct(cosplayNaruto);
		productService.saveProduct(clotheBNHA);

		Client admin = new Client ("Admin", "admin", "admin@orgm.com", passwordEncoder.encode("soyadmin"), "2996827417");
		Client client = new Client ("Melbita", "Morel", "melba@mindhub.com", passwordEncoder.encode("melba"), "2993910932");
		clientService.saveClient(admin);
		clientService.saveClient(client);

	};
	}


}
