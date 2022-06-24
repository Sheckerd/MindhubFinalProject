package com.PatitosdeHule.eCommerce;

import com.PatitosdeHule.eCommerce.models.*;
import com.PatitosdeHule.eCommerce.services.ArticleService;
import com.PatitosdeHule.eCommerce.services.ClientService;
import com.PatitosdeHule.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
        System.out.println("Juegue Caballero!");
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner init(ProductService productService, ClientService clientService, ArticleService articleService) {
        return args -> {

//Cosplay
		Product cosplayNaruto = new Product("naruto set", "traje naruto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "naruto theme", true, ProductType.COSPLAY, ClothesSize.M,20,400d);
		productService.saveProduct(cosplayNaruto);

         Product cosplaySKNMikasa = new Product("Mikasa set", "Legión de reconocimeinto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Shingeki no Kyojin theme", true, ProductType.COSPLAY, ClothesSize.M, 20, 400d);
         productService.saveProduct(cosplaySKNMikasa);

         Product cosplayMHADeku = new Product("Boku set", "My Hero Academy", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", " My Hero Academy", true, ProductType.COSPLAY, ClothesSize.L, 20, 400d);
         productService.saveProduct(cosplayMHADeku);

         Product cosplayMHA = new Product("Boku set", "My Hero Academy", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", " My Hero Academy", true, ProductType.COSPLAY, ClothesSize.L, 20, 400d);
         productService.saveProduct(cosplayMHA);

         Product vegeta = new Product("vegeta set", "traje de vegeta algodon", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "dragon ball", true, ProductType.COSPLAY, ClothesSize.L, 14, 1000d);
         productService.saveProduct(vegeta);


// Clothes
		Product clotheBNHA = new Product("Remera Izuki", "verde/c negro", "Una remera muito delicia mmmmmm", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "BNHA", ClothesType.T_SHIRT, false, ProductType.CLOTHES, ClothesSize.S, 17, 250);
		productService.saveProduct(clotheBNHA);

		Product clotheHoodie = new Product("Hoodie Origami", "Gris", "Un hoodie muito delicioso mmmmmm", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, ClothesSize.L, 17, 250);
        productService.saveProduct(clotheHoodie);


            //Cosplay



            //Articles

            Article article = new Article(clotheHoodiePsycho, 1, clotheHoodiePsycho.getPrice());
            articleService.saveArticle(article);
            Article article1 = new Article(clotheHoodiePsycho, 2, clotheHoodie.getPrice());
            articleService.saveArticle(article1);

        };
    }


}
