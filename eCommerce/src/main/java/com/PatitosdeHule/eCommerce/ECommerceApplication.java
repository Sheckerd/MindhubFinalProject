package com.PatitosdeHule.eCommerce;

import com.PatitosdeHule.eCommerce.models.*;
import com.PatitosdeHule.eCommerce.services.ClientService;
import com.PatitosdeHule.eCommerce.services.InvoiceService;
import com.PatitosdeHule.eCommerce.services.ProductListService;
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
    public CommandLineRunner init(ProductService productService, ClientService clientService, ProductListService ProductlistService, InvoiceService invoiceService) {
        return args -> {

//Cosplay
            //Naruto
            Product cosplayNaruto = new Product("Naruto set", "Traje Naruto", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Naruto theme", false, ProductType.COSPLAY, List.of("S","M","L"),19,1500d);
            productService.saveProduct(cosplayNaruto);

            Product cosplayKakashi = new Product("Kakashi set", "Traje Kakashi", "https://i.imgur.com/EO5b61a.png", "Naruto theme", false, ProductType.COSPLAY, List.of("S","M","L"),15,1500d);
            productService.saveProduct(cosplayKakashi);

            Product cosplayItachi = new Product("Itachi set", "Traje Itachi", "https://i.imgur.com/jPOUhwZ.png", "Naruto theme",false, ProductType.COSPLAY, List.of("S","M","L"),20,1600d);
            productService.saveProduct(cosplayItachi);

            Product cosplayKaguya = new Product("Kaguya set", "Traje Kaguya", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "Naruto theme", false, ProductType.COSPLAY,List.of("S","M","L"),23,1500d);
            productService.saveProduct(cosplayKaguya);

            Product cosplaySasuke = new Product("Sasuke set", "Traje Sasuke", "https://i.imgur.com/0QmByT7.png", "Naruto theme", false, ProductType.COSPLAY, List.of("S","M","L"),17,1500d);
            productService.saveProduct(cosplaySasuke);

            Product cosplaySakura = new Product("Sakura set", "Traje Sakura", "https://i.imgur.com/7W6hpVp.png", "Naruto theme", false, ProductType.COSPLAY, List.of("S","M","L"),20,1500d);
            productService.saveProduct(cosplaySakura);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Shingeki no Kyojin
            Product cosplaySKNLevi = new Product("Levi set", "Legión de reconocimeinto", "https://i.imgur.com/tQGdrat.png", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplaySKNLevi);

            Product cosplaySKNMikasa = new Product("Mikasa set", "Legión de reconocimeinto", "https://i.imgur.com/VRgdZRf.png", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplaySKNMikasa);

            Product cosplaySKNEren = new Product("Eren set", "Legión de reconocimeinto", "https://i.imgur.com/kQCffqm.png", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplaySKNEren);

            Product cosplaySKNTraje = new Product("Legión de Reconocimiento set", "Legión de reconocimeinto", "https://i.imgur.com/3Fl6hb1.png", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplaySKNTraje);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Sailor Moon
            Product sailorNepturno = new Product("Sailor Nepturno set", "Traje Sailor Nepturno", "https://i.imgur.com/9h4vQOA.png", "Sailor Moon", false, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sailorNepturno);

            Product sailorMoon = new Product("Sailor Moon set", "Traje Sailor Moon", "https://i.imgur.com/ekCfCgT.png", "Sailor Moon", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sailorMoon);

            Product sailorMercury = new Product("Sailor Mercury set", "Traje Sailor Mercury", "https://i.imgur.com/6gxseN5.jpg", "Sailor Moon", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sailorMercury);

            Product sailorVenus = new Product("Sailor Venus set", "Traje Sailor Venus", "https://i.imgur.com/u61IwJh.png", "Sailor Moon", false, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sailorVenus);

            Product sailorMars = new Product("Sailor Mars set", "Traje Sailor Mars", "https://i.imgur.com/pyEAxAI.png", "Sailor Moon", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sailorMars);

            Product sailorJupiter = new Product("Sailor Jupiter set", "Traje Sailor Jupiter", "https://i.imgur.com/C1ChVLX.jpg", "Sailor Moon", false, ProductType.COSPLAY,List.of("S","M","L"), 2, 1000d);
            productService.saveProduct(sailorJupiter);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Boku no Hero
            Product cosplayMHADeku = new Product("Deku set", "Deku Costume", "https://i.imgur.com/7WpevQq.png", " My Hero Academy", true, ProductType.COSPLAY, List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplayMHADeku);

            Product cosplayMHATodoroki = new Product("Todoroki set", "Todoroki Costume", "https://i.imgur.com/7JmQOoj.png", " My Hero Academy", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplayMHATodoroki);

            Product cosplayAllMight = new Product("All Might set", "All Might Costume", "https://i.imgur.com/s7ydIuT.png", " My Hero Academy", true, ProductType.COSPLAY,List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplayAllMight);

            Product cosplayTooru = new Product("Tooru set", "Tooru Costume", "https://i.imgur.com/OyOYh4u.png", " My Hero Academy", false, ProductType.COSPLAY,List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplayTooru);

            Product cosplayUraraka = new Product("Uraraka set", "Uraraka costume", "https://i.imgur.com/oCUnc6J.png", " My Hero Academy", false, ProductType.COSPLAY,List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplayUraraka);

            Product cosplayBakugou = new Product("Bakugou set", "Bakugou costume", "https://i.imgur.com/Ggxiscq.png", " My Hero Academy", false, ProductType.COSPLAY,List.of("S","M","L"), 20, 400d);
            productService.saveProduct(cosplayBakugou);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Dragon Ball
            Product vegeta = new Product("Vegetta set", "Traje de Vegetta", "https://i.imgur.com/28pD4Km.png", "Dragon Ball", true, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(vegeta);

            Product bulma = new Product("Bulma set", "Traje de Bulma", "https://i.imgur.com/YkTlCWb.png", "Dragon Ball", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(bulma);

            Product gokuSSJ = new Product("goku set", "Goku Dragon Ball Super", "https://i.imgur.com/XNJMLEB.jpg", "Dragon Ball", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(gokuSSJ);

            Product Milk = new Product("Milk set", "Traje de Milk (Chichi)", "https://i.imgur.com/Hxr7Vix.png", "Dragon Ball", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(Milk);

            Product gohanSJJ = new Product("Gohan set", "Traje de Gohan Super Saiyajin 1", "https://i.imgur.com/yQitXnm.jpg", "Dragon Ball", false, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(gohanSJJ);

            Product trunks = new Product("Trunks set", "Traje de Trunks", "https://i.imgur.com/JJ3lzx5.jpg", "Dragon Ball", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(trunks);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            // Kimetsu no Yaiba
            Product nezuko = new Product("Nezuko set", "Traje de Nezuko", "https://i.imgur.com/4Anmbyf.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(nezuko);

            Product tanjiro = new Product("Tanjiro set", "traje de Tanjiro", "https://i.imgur.com/LbNdDBX.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(tanjiro);

            Product mitsuri = new Product("Mitsuri set", "Traje de Misuri", "https://i.imgur.com/ZZDMzrf.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(mitsuri);

            Product inosuke = new Product("Inosuke set", "Traje de Inosuke", "https://i.imgur.com/CVfkIvR.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(inosuke);

            Product rengoku = new Product("Rengoku set", "Traje de Rengoku", "https://i.imgur.com/hBw0AtT.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(rengoku);

            Product zenitsu = new Product("Zenitsu set", "Traje de Zenitsu", "https://i.imgur.com/mcsteGK.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(zenitsu);

            Product shinobu= new Product("Shinobu set", "Traje de Shinobu", "https://i.imgur.com/UshO4IS.jpg", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(shinobu);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Jujutsu kaisen
            Product nobara = new Product("Nobara set", "Traje de Nobara", "https://i.imgur.com/gNed8TH.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(nobara);

            Product gojo = new Product("Gojo set", "Traje de Gojo", "https://i.imgur.com/HYwoEHz.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(gojo);

            Product itadori = new Product("Itadori set", "Traje de Itadori", "https://i.imgur.com/YIpKz0i.png", "Jujutsu Kaisen", false, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(itadori);

            Product okkotsu = new Product("Okkotsu set", "Traje de Okkotsu", "https://i.imgur.com/it5M658.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(okkotsu);

            Product megumi = new Product("Megumi  set", "Traje de Megumi", "https://i.imgur.com/IxOo414.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(megumi);

            Product zenin = new Product("Zenin set", "Traje de Zenin", "https://i.imgur.com/9B7hjHd.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(zenin);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Sword Art Online
            Product kirito = new Product("Kirito set", "Traje de Kirito", "https://i.imgur.com/82MNAGf.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(kirito);

            Product asuna = new Product("Asuna set", "Traje de Asuna", "https://i.imgur.com/6jzahmD.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(asuna);

            Product klain = new Product("Klain set", "Traje de Kirito", "https://i.imgur.com/ZjWL7f8.jpg", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(klain);

            Product yuna = new Product("Yuna set", "Traje de Yuna", "https://i.imgur.com/ru2r6nh.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(yuna);

            Product sinon = new Product("Sinon set", "Traje de Sinon", "https://i.imgur.com/ac0fkyz.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sinon);

            Product kiritoGGO = new Product("Kirito GGO set", "Traje de Kirito GGO", "https://i.imgur.com/PmuWD5K.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(kiritoGGO);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Bleach
            Product bleach = new Product("Bleach set", "Túnica de Bleach", "https://i.imgur.com/YsNWxni.png", "Bleach", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(bleach);

            Product ichigo = new Product("Ichigo set", "Túnica de Ichigo", "https://i.imgur.com/XHwFO3q.png", "Bleach", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(ichigo);

            Product rukia= new Product("Rukia set", "Traje escolar Rukia", "https://i.imgur.com/b9pDMlx.png", "Bleach", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(rukia);

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Dororo
            Product hyakkimaru = new Product("Hyakkimaru set", "Túnica de Hyakkimaru", "foto que no hay","Dororo",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(hyakkimaru);

            Product mio = new Product("Mio set", "Túnica de Mio","https://i.imgur.com/7818a6r.png", "Dororo",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(mio);

            Product tahoumaru = new Product("Tahoumaru set", "Túnica de Tahoumaru", "https://i.imgur.com/hZK9Y4Q.jpg","Dororo",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(tahoumaru);

            Product dororo = new Product("Dororo set", "Túnica de Dororo", "https://i.imgur.com/w9Kj6Ac.jpg","Dororo",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(dororo);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Mob Psycho 100
            Product shigeo = new Product("Shigeo set", "Traje Shigeo", "https://i.imgur.com/VjMZ1pI.jpg","Mob Psycho 100",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(shigeo);

            Product reigen = new Product("Reigen set", "Traje Reigen", "https://i.imgur.com/WtileHc.jpg","Mob Psycho 100",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(reigen);

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Evangelion
            Product shinji = new Product("Shinji set", "Traje Shinji", "https://i.imgur.com/RAG4rky.jpg","Evangelion",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(shinji);

            Product asuka = new Product("Asuka set", "Traje Asuka", "https://i.imgur.com/VPnJbfH.jpg","Evangelion",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(asuka);

            Product rei = new Product("Rei set", "Traje Rei", "https://i.imgur.com/NkDJMs3.jpg","Evangelion",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(rei);

            Product misato= new Product("Misato set", "Traje Misato", "https://i.imgur.com/wFlETGK.jpg","Evangelion",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(misato);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Tokyo Ghoul
            Product kaneki= new Product("Kaneki set", "Traje Kaneki", "https://i.imgur.com/agk47hZ.jpg","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(kaneki);

            Product touka= new Product("Touka set", "Traje Touka", "https://i.imgur.com/HkuRtRV.jpg","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(touka);

            Product rize= new Product("Rize set", "Traje Rize", "https://i.imgur.com/qnSJXXh.jpg","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(rize);

            Product tsukiyama= new Product("Tsukiyama set", "Traje Tsukiyama", "https://i.imgur.com/Wg7GNqz.jpg","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(tsukiyama);

            Product suzuya= new Product("Suzuya set", "Traje Suzuya", "https://i.imgur.com/cCMUKP2.jpg","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(suzuya);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Spy X Family
            Product anya= new Product("Anya set", "Traje Anya", "https://i.imgur.com/RD75uXA.jpg","SpyXFamily",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(anya);

            Product loid= new Product("Loid Froge set", "Traje Loid Froge", "https://i.imgur.com/bMNTfnk.jpg","SpyXFamily",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(loid);

            Product yorFroge= new Product("Yor Froge set", "Traje Spy Yor Froge", "https://i.imgur.com/OtWvoD1.jpg","SpyXFamily",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(yorFroge);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆

  // Clothes

            //remeras
            Product remeraIzuki = new Product("Remera Izuki", List.of("gray"), "Remera de Izuki, 100% algodón", "", "  ", "BNHA", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 17, 250);
            productService.saveProduct(remeraIzuki);
                    //remeras origami
                     Product shirtVandalOriBlue = new Product("Remera Izuki", List.of("blue"), "Remera Origami, VANDALISM.R.O edition. 100% Algodón", "https://i.imgur.com/2O3xyuG.png", "https://i.imgur.com/chmMZIb.png", "Origami Boom", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
                     productService.saveProduct(shirtVandalOriBlue);
                     Product shirtVandalOriBlack = new Product ("Remera Vandalori Black", List.of("black"),"Remera Origami, VANDALISM.R.O edition. 100% Algodón","https://i.imgur.com/2O3xyuG.png","https://i.imgur.com/2O3xyuG.png","Origami Boom",ClothesType.T_SHIRT,false,ProductType.CLOTHES,List.of("S","M","L"),10,300);
                     productService.saveProduct(shirtVandalOriBlack);
            Product shirtVandalOriRed = new Product("Remera Izuki", List.of("red"), "Remera Origami, VANDALISM.R.O edition. 100% Algodón", "https://i.imgur.com/30ihABU.png", "https://i.imgur.com/VcWLysG.png", "Origami Boom", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(shirtVandalOriRed);
            Product shirtVandalOriGray = new Product("Remera Izuki", List.of("grey"), "Remera Origami, VANDALISM.R.O edition. 100% Algodón", "https://i.imgur.com/wXT712h.png", "https://i.imgur.com/NLjZX6e.png", "Origami Boom", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(shirtVandalOriGray);
            Product shirtVandalOriPink = new Product("Remera Izuki", List.of("pink"), "Remera Origami, VANDALISM.R.O edition. 100% Algodón", "https://i.imgur.com/VkKeubu.png", "https://i.imgur.com/zWYf83T.png", "Origami Boom", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(shirtVandalOriPink);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆

            //buzos  resolucion 320 y 540(aclarar)

            Product hoodieHyakkimaru = new Product("Hoodie Hyakkimaru", List.of("grey"), "Hoodie de Hyakkimaru, 100% algodón.", "https://i.imgur.com/pbnvMoQ.png","https://i.imgur.com/pbnvMoQ.png", "Dororo", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(hoodieHyakkimaru);

            Product hoodiePsycho = new Product("Hoodie Psycho", List.of("grey"), "Hoodie Mob Psycho 100", "https://i.imgur.com/YptBDwF.png", "https://i.imgur.com/YptBDwF.png", "Mob Psycho 100", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(hoodiePsycho);

            //hoodies origami vansalism
            Product hoodieVandalOriBlack = new Product("Hoodie Vandalims Black ", List.of("black","white"), "Hoodie negro 100%, Vandalism Origami edition", "https://i.imgur.com/kIMBu2N.jpg", "https://i.imgur.com/2x5GTnt.jpg", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(hoodieVandalOriBlack);//viene en negro y blanco

            Product hoodieVandalOriBlanco = new Product("Hoodie Vandalims Blanco", List.of("white","black"), "Hoodie blanco 100%, Vandalism Origami edition", "https://i.imgur.com/Kk1YT8I.jpg", "https://i.imgur.com/qsn39Bk.jpg", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(hoodieVandalOriBlanco);//viene en negro y blanco

            //hoodie origami logo
             Product hoodieLogoBlack = new Product("Hoodie Origami", List.of("Black"), "Hoodie negro 100% algodón, Origami edition", "https://i.imgur.com/kuewxMn.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieLogoBlack);

             Product hoodieMiniLogoBlack = new Product("Hoodie Origami", List.of("black"), "Hoodie negro 100% algodón, Origami  edition", "https://i.imgur.com/AUadhhb.png", "https://i.imgur.com/AUadhhb.png", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieMiniLogoBlack);

             Product hoodieLogoWhite = new Product("Hoodie Origami", List.of("White"), "Hoodie blanco 100% algodón, Origami edition", "https://i.imgur.com/mTdbjYu.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieLogoWhite);

             Product hoodieLogoRed = new Product("Hoodie Origami", List.of("Red"), "Hoodie rojo 100% algodón, Origami edition", "https://i.imgur.com/XqbbHc6.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieLogoRed);

             Product hoodieLogoPink = new Product("Hoodie Origami", List.of("Pink"), "Hoodie rosa 100% algodón, Origami edition", "https://i.imgur.com/U9xtsc2.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieLogoPink);

             Product hoodieLogoBlue = new Product("Hoodie Origami", List.of("Blue"), "Hoodie azul 100% algodón, Origami edition", "https://i.imgur.com/ZXwlMFz.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieLogoBlue);

             Product hoodieOriYellow = new Product("Hoodie Origami", List.of("grey"), "Hoodie gris 100% algodón, Origami  edition", "https://i.imgur.com/Cn61Mxn.png", "https://i.imgur.com/7cckw6d.png", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieOriYellow);

             //hoodieMultiOri
             Product hoodieMultiOriGrey = new Product("Hoodie Logo Origami", List.of("Grey","Black"), "Hoodie gris con logos negros Origami, 100% algodón, Origami edition", "https://i.imgur.com/z29hH8w.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieMultiOriGrey);

             Product hoodieMultiOriWhite = new Product("Hoodie Logo Origami", List.of("White","Black"), "Hoodie blanco con logos negros Origami, 100% algodón, Origami edition", "https://i.imgur.com/4fTcNco.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
             productService.saveProduct(hoodieMultiOriWhite);

           // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆

            //pantalones  resoluciuon 320 y 540(aclarar)
            Product vandalTrousers = new Product("Vandalismo.R.O Trousers", List.of("white"), "Un hoodie muito delicioso mmmmmm", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "Origami", ClothesType.TROUSER, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(vandalTrousers);//viene en blanco y en negro

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Zapatillas, resoluciuon 320 y 540(aclarar)
            Product vandalNike = new Product("Origami Nikes", List.of("black","white"), "Un hoodie muito delicioso mmmmmm", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "Origami", ClothesType.SNEAKER,true, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(vandalNike);

            Product vandalNikeBlack = new Product("Origami Black Nikes", List.of("black","white"), "Un hoodie muito delicioso mmmmmm", "https://i.ebayimg.com/thumbs/images/g/i0gAAOSwKpph3OLh/s-l300.jpg", "https://d3ugyf2ht6aenh.cloudfront.net/stores/830/660/products/zt-0686-frente-9744de8f9c1d9597e116038240713155-1024-1024.jpg", "Origami", ClothesType.SNEAKER, true, ProductType.CLOTHES, List.of("S","M","L"), 17, 250);
            productService.saveProduct(vandalNikeBlack);

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆

            //las gorras no están incluidas en los enum, tampoco las camperas
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆ Nico apaga la compu
            //

            //Client
            Client client1 = new Client("Ola", "María", "ivojavierpr@gmail.com", passwordEncoder.encode("jujuju"), "uwu",true);
            clientService.saveClient(client1);

            Client client2 = new Client ("admin","admin","admin@admin.com", passwordEncoder.encode("123"),"32516495",false );
            clientService.saveClient(client2);
            //Invoice

            Invoice invoice = new Invoice(client1, PaymentMethods.CREDIT,ShippingType.HOME_DELIVERY,"1326-0001",1000, LocalDateTime.now());
            invoiceService.saveInvoices(invoice);

            //ProductList

            ProductList productList = new ProductList(hoodieVandalOriBlack ,3,45, invoice);
            ProductlistService.saveProductList(productList);
            ProductList productList1 = new ProductList(remeraIzuki,4,20,invoice);  // equisde
            ProductlistService.saveProductList(productList1);

            //
            Invoice invoice1 = new Invoice(client1, PaymentMethods.DEBIT, ShippingType.SHOP_PICKUP, "B0001-00000025", 500d, LocalDateTime.now());
            invoiceService.saveInvoices(invoice1);

        };
    }


}
