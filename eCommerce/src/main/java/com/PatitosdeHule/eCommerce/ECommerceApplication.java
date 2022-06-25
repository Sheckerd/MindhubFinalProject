package com.PatitosdeHule.eCommerce;

import com.PatitosdeHule.eCommerce.models.*;
import com.PatitosdeHule.eCommerce.repositories.InvoiceRepository;
import com.PatitosdeHule.eCommerce.services.ArticleService;
import com.PatitosdeHule.eCommerce.services.ClientService;
import com.PatitosdeHule.eCommerce.services.InvoiceService;
import com.PatitosdeHule.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
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
    public CommandLineRunner init(ProductService productService, ClientService clientService, ArticleService articleService, InvoiceService invoiceService) {
        return args -> {

//Cosplay
      //Naruto
		Product cosplayNaruto = new Product("naruto set", "traje naruto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "naruto theme", true, ProductType.COSPLAY, ClothesSize.M,20,400d);
		productService.saveProduct(cosplayNaruto); //hay foto

        Product cosplayKakashi = new Product("Kakashi set", "traje Kakashi", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Naruto theme", true, ProductType.COSPLAY, ClothesSize.M,20,400d);
        productService.saveProduct(cosplayKakashi); //hay foto

        Product cosplayItachi = new Product("Itachi set", "traje Itachi", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Naruto theme", true, ProductType.COSPLAY, ClothesSize.L,20,400d);
        productService.saveProduct(cosplayItachi);//hay foto

        Product cosplayKaguya = new Product("Kaguya set", "traje Kaguya", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Naruto theme", true, ProductType.COSPLAY, ClothesSize.S,20,400d);
        productService.saveProduct(cosplayKaguya);//hay foto

        Product cosplaySasuke = new Product("Sasuke set", "traje Sasuke", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Naruto theme", false, ProductType.COSPLAY, ClothesSize.S,20,400d);
        productService.saveProduct(cosplaySasuke);//no hay foto

        Product cosplaySakura = new Product("Sakura set", "traje Sakura", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Naruto theme", false, ProductType.COSPLAY, ClothesSize.XS,20,400d);
        productService.saveProduct(cosplaySakura);//no hay foto
   // __________-------_______-------_______--------//

    //Shingeki no Kyojin
         Product cosplaySKNLevi = new Product("Levi set", "Legión de reconocimeinto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, ClothesSize.M, 20, 400d);
         productService.saveProduct(cosplaySKNLevi);//hay foto

         Product cosplaySKNMikasa = new Product("Mikasa set", "Legión de reconocimeinto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, ClothesSize.M, 20, 400d);
         productService.saveProduct(cosplaySKNMikasa);//no hay foto

         Product cosplaySKNEren = new Product("Eren set", "Legión de reconocimeinto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, ClothesSize.M, 20, 400d);
         productService.saveProduct(cosplaySKNEren);//no hay foto

         Product cosplaySKNColosal = new Product("Colosal Titan", "Colosal Titan costume", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, ClothesSize.M, 20, 400d);
         productService.saveProduct(cosplaySKNColosal);//no hay foto

         Product cosplaySKNTraje = new Product("Legión de Reconocimiento set", "Legión de reconocimeinto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, ClothesSize.L, 20, 400d);
         productService.saveProduct(cosplaySKNTraje);//no hay foto
   // __________-------_______-------_______--------//

    //Sailor Moon
         Product sailorNepturno = new Product("Sailor Nepturno set", "traje Sailor Nepturno", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sailor Moon", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
         productService.saveProduct(sailorNepturno); //hay foto

         Product sailorMoon = new Product("Sailor Moon set", "traje Sailor Moon", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sailor Moon", false, ProductType.COSPLAY, ClothesSize.S, 14, 1000d);
         productService.saveProduct(sailorMoon);//no hay foto
         Product sailorMercury = new Product("Sailor Mercury set", "traje Sailor Mercury", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sailor Moon", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
         productService.saveProduct(sailorMercury);//no hay foto

         Product sailorVenus = new Product("Sailor Venus set", "traje Sailor Venus", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sailor Moon", false, ProductType.COSPLAY, ClothesSize.L, 14, 1000d);
         productService.saveProduct(sailorVenus);//no hay foto

         Product sailorMars = new Product("Sailor Mars set", "traje Sailor Mars", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sailor Moon", false, ProductType.COSPLAY, ClothesSize.S, 14, 1000d);
         productService.saveProduct(sailorMars);//no hay foto

         Product sailorJupiter = new Product("Sailor Jupiter set", "traje Sailor Jupiter", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sailor Moon", false, ProductType.COSPLAY, ClothesSize.XL, 14, 1000d);
         productService.saveProduct(sailorJupiter);//no hay foto
   // __________-------_______-------_______--------//

    //Boku no Hero
         Product cosplayMHADeku = new Product("Deku set", "Deku Costume", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", " My Hero Academy", true, ProductType.COSPLAY, ClothesSize.L, 20, 400d);
         productService.saveProduct(cosplayMHADeku);//no hay foto

         Product cosplayMHATodoroki = new Product("Todoroki set", "Todoroki Costume", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", " My Hero Academy", false, ProductType.COSPLAY, ClothesSize.L, 20, 400d);
         productService.saveProduct(cosplayMHATodoroki);//no hay foto

         Product cosplayAllMight = new Product("All Might set", "All Might Costume", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", " My Hero Academy", true, ProductType.COSPLAY, ClothesSize.XL, 20, 400d);
         productService.saveProduct(cosplayAllMight);//Hay foto

         Product cosplayTooru = new Product("Tooru set", "Tooru Costume", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", " My Hero Academy", false, ProductType.COSPLAY, ClothesSize.S, 20, 400d);
         productService.saveProduct(cosplayTooru);//hay foto

         Product cosplayUraraka = new Product("Uraraka set", "Uraraka costume", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", " My Hero Academy", false, ProductType.COSPLAY, ClothesSize.XS, 20, 400d);
         productService.saveProduct(cosplayUraraka);//no hay foto

         Product cosplayBakugou = new Product("Bakugou set", "Bakugou costume", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", " My Hero Academy", false, ProductType.COSPLAY, ClothesSize.M, 20, 400d);
         productService.saveProduct(cosplayBakugou);//no hay foto
   // __________-------_______-------_______--------//

    //Dragon Ball
         Product vegeta = new Product("vegeta set", "traje de vegeta algodon", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "dragon ball", true, ProductType.COSPLAY, ClothesSize.L, 14, 1000d);
         productService.saveProduct(vegeta);//hay foto

         Product bulma = new Product("Bulma set", "traje de Bulma algodon", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "dragon ball", false, ProductType.COSPLAY, ClothesSize.XS, 14, 1000d);
         productService.saveProduct(bulma);//no hay foto

         Product gokuSSJ = new Product("goku set", "Goku Super Saiyajin 1", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "dragon ball", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
         productService.saveProduct(gokuSSJ);//no hay foto

         Product Milk = new Product("Milk set", "traje de Milk (Chichi) de algodon", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "dragon ball", false, ProductType.COSPLAY, ClothesSize.S, 14, 1000d);
         productService.saveProduct(Milk);//no hay foto

         Product gohanSJJ = new Product("Gohan set", "traje de Gohan Super Saiyajin 1", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "dragon ball", false, ProductType.COSPLAY, ClothesSize.L, 14, 1000d);
         productService.saveProduct(gohanSJJ);//no hay foto

         Product trunks = new Product("Trunks set", "traje de Trunks algodon", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "dragon ball", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
         productService.saveProduct(trunks);//no hay foto
   // __________-------_______-------_______--------//
    // Kimetsu no Yaiba
         Product nezuko = new Product("Nezuko set", "traje de Nezuko", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Kimetsu no Yaiba", false, ProductType.COSPLAY, ClothesSize.XL, 14, 1000d);
         productService.saveProduct(nezuko);//hay foto

         Product tanjiro = new Product("Tanjiro set", "traje de Tanjiro", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Kimetsu no Yaiba", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
         productService.saveProduct(tanjiro);//hay foto

         Product mitsuri = new Product("Mitsuri set", "Traje de Misuri", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Kimetsu no Yaiba", false, ProductType.COSPLAY, ClothesSize.S, 14, 1000d);
         productService.saveProduct(mitsuri);//hay foto

         Product inosuke = new Product("Inosuke set", "Traje de Inosuke", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Kimetsu no Yaiba", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
         productService.saveProduct(inosuke);//no hay foto

         Product rengoku = new Product("Rengoku set", "Traje de Rengoku", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Kimetsu no Yaiba", false, ProductType.COSPLAY, ClothesSize.L, 14, 1000d);
         productService.saveProduct(rengoku);//no hay foto

         Product zenitsu = new Product("Zenitsu set", "Traje de Zenitsu", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Kimetsu no Yaiba", false, ProductType.COSPLAY, ClothesSize.S, 14, 1000d);
         productService.saveProduct(zenitsu);//No hay foto
   // __________-------_______-------_______--------//

    //Jujutsu kaisen
         Product nobara = new Product("Nobara set", "Traje de Nobara", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Jujutsu Kaisen", false, ProductType.COSPLAY, ClothesSize.S, 14, 1000d);
         productService.saveProduct(nobara);

         Product gojo = new Product("Gojo set", "Traje de Gojo", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Jujutsu Kaisen", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
         productService.saveProduct(gojo);

         Product itadori = new Product("Itadori set", "Traje de Itadori", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Jujutsu Kaisen", false, ProductType.COSPLAY, ClothesSize.L, 14, 1000d);
         productService.saveProduct(itadori);

         Product okkotsu = new Product("Okkotsu set", "Traje de Okkotsu", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Jujutsu Kaisen", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
         productService.saveProduct(okkotsu);

         Product megumi = new Product("Megumi  set", "Traje de Megumi", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Jujutsu Kaisen", false, ProductType.COSPLAY, ClothesSize.XL, 14, 1000d);
         productService.saveProduct(megumi);
   // __________-------_______-------_______--------//
    //Sword Art Online
           Product kirito = new Product("Kirito set", "Traje de Kirito", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sword Art Online", false, ProductType.COSPLAY, ClothesSize.M, 14, 1000d);
           productService.saveProduct(kirito);//hay foto

           Product asuna = new Product("Asuna set", "Traje de Asuna", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sword Art Online", false, ProductType.COSPLAY, ClothesSize.XS, 14, 1000d);
           productService.saveProduct(asuna);//no hay foto

           Product klain = new Product("Klain set", "Traje de Kirito", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Sword Art Online", false, ProductType.COSPLAY, ClothesSize.L, 14, 1000d);
           productService.saveProduct(klain);//no hay foto
   // __________-------_______-------_______--------//
    //Bleach
           Product bleach = new Product("Bleach set", "Túnica de Bleach", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Bleach", false, ProductType.COSPLAY, ClothesSize.L, 14, 1000d);
           productService.saveProduct(bleach);
   // __________-------_______-------_______--------//
// Clothes
		Product clotheBNHA = new Product("Remera Izuki", List.of("gray"), "Una remera muito delicia mmmmmm", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "BNHA", ClothesType.T_SHIRT, false, ProductType.CLOTHES, ClothesSize.S, 17, 250);
		productService.saveProduct(clotheBNHA);

		Product clotheHoodie = new Product("Hoodie Origami", List.of("black"), "Un hoodie muito delicioso mmmmmm", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, ClothesSize.L, 17, 250);
        productService.saveProduct(clotheHoodie);

        Product clotheHoodiePsycho = new Product("Hoodie Psycho", List.of("black, grey"), "Un hoodie muito delicioso mmmmmm", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, ClothesSize.XL, 17, 250);
        productService.saveProduct(clotheHoodiePsycho);


            //Cosplay






            //Articles




            Client client = new Client("Ola", "María", "ivojavierpr@gmail.com", "jujuju", "uwu");
            clientService.saveClient(client);

            //Invoice

            Invoice invoice = new Invoice(client, PaymentMethods.CREDIT,ShippingType.HOME_DELIVERY,"1326-0001",1000, LocalDateTime.now());
            invoiceService.saveInvoices(invoice);

            //Article

            Article article = new Article(clotheHoodie,3,45, invoice);
            articleService.saveArticle(article);
            Article article1 = new Article(clotheBNHA,4,20,invoice);  // equisde
            articleService.saveArticle(article1);

            //
            Invoice invoice1 = new Invoice(client, PaymentMethods.DEBIT, ShippingType.SHOP_PICKUP, "B0001-00000025", 500d, LocalDateTime.now());
            invoiceService.saveInvoices(invoice1);

        };
    }


}
