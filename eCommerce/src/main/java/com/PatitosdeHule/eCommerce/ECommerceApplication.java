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

import static com.PatitosdeHule.eCommerce.utils.Utils.getRandomNumber;


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
            Product cosplayNaruto = new Product("Naruto set", "Traje Naruto", "https://i.imgur.com/Ph0ejMF.png", "Naruto theme", false, ProductType.COSPLAY, List.of("S","M","L"),19,1500d);
            productService.saveProduct(cosplayNaruto);

            Product cosplayKakashi = new Product("Kakashi set", "Traje Kakashi, incluye guantes, pantalón, camisa y chaleco", "https://i.imgur.com/EO5b61a.png", "Naruto theme", false, ProductType.COSPLAY, List.of("S","M","L"),15,1500d);
            productService.saveProduct(cosplayKakashi);

            Product cosplayItachi = new Product("Itachi set", "Traje Itachi, incluye túnica, bandana, collar y shuriken", "https://i.imgur.com/jPOUhwZ.png", "Naruto theme",false, ProductType.COSPLAY, List.of("S","M","L"),20,1600d);
            productService.saveProduct(cosplayItachi);

            Product cosplaySasuke = new Product("Sasuke set", "Traje Sasuke, incluye bandana, peluca, túnica, pantalón y soga", "https://i.imgur.com/0QmByT7.png", "Naruto theme", false, ProductType.COSPLAY, List.of("S","M","L"),17,1500d);
            productService.saveProduct(cosplaySasuke);

            Product cosplaySakura = new Product("Sakura set", "Traje Sakura, incluye bandana, peluca, botas,vendas,guantes,traje y kunai", "https://i.imgur.com/7W6hpVp.png", "Naruto theme", false, ProductType.COSPLAY, List.of("S","M","L"),10,1500d);
            productService.saveProduct(cosplaySakura);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Shingeki no Kyojin
            Product cosplaySKNLevi = new Product("Levi set", "Legión de Reconocimeinto, inluye capa, pantalón, arnés, botas, camisa y pañuelo", "https://i.imgur.com/tQGdrat.png", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 1700d);
            productService.saveProduct(cosplaySKNLevi);

            Product cosplaySKNMikasa = new Product("Mikasa set", "Legión de Reconocimeinto, inluye capa, pantalón, arnés, botas, camisa y bufanda roja", "https://i.imgur.com/VRgdZRf.png", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, List.of("S","M","L"), 8, 1700d);
            productService.saveProduct(cosplaySKNMikasa);

            Product cosplaySKNEren = new Product("Eren set", "Legión de Reconocimeinto, inluye capa, pantalón, arnés, botas, camisa marrón y colgante de llave", "https://i.imgur.com/kQCffqm.png", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 1700d);
            productService.saveProduct(cosplaySKNEren);

            Product cosplaySKNTraje = new Product("Legión de Reconocimiento set", "Legión de Reconocimeinto, inluye capa, pantalón, arnés, botas, camisa y campera de cuero marrón con las alas de la libertad", "https://i.imgur.com/3Fl6hb1.png", "Shingeki no Kyojin theme", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 1900d);
            productService.saveProduct(cosplaySKNTraje);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Sailor Moon
            Product sailorNepturno = new Product("Sailor Nepturno set", "Traje Sailor Nepturno, incluye guantes, collar  y uniforme", "https://i.imgur.com/9h4vQOA.png", "Sailor Moon", false, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sailorNepturno);

            Product sailorMoon = new Product("Sailor Moon set", "Traje Sailor Moon, incluye uniforme, guantes, collar y botas", "https://i.imgur.com/ekCfCgT.png", "Sailor Moon", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sailorMoon);

            Product sailorMercury = new Product("Sailor Mercury set", "Traje Sailor Mercury, incluye uniforme, guantes y collar", "https://i.imgur.com/6gxseN5.jpg", "Sailor Moon", false, ProductType.COSPLAY,List.of("S","M","L"), 6, 1000d);
            productService.saveProduct(sailorMercury);

            Product sailorVenus = new Product("Sailor Venus set", "Traje Sailor Venus, incluye guantes, uniforme y collar", "https://i.imgur.com/opS6RMt.png", "Sailor Moon", false, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(sailorVenus);

            Product sailorMars = new Product("Sailor Mars set", "Traje Sailor Mars, incluye guantes, uniforme y collar", "https://i.imgur.com/pyEAxAI.png", "Sailor Moon", false, ProductType.COSPLAY,List.of("S","M","L"), 19, 1000d);
            productService.saveProduct(sailorMars);

            Product sailorJupiter = new Product("Sailor Jupiter set", "Traje Sailor Jupiter, incluye guantes, uniforme y collar", "https://i.imgur.com/C1ChVLX.jpg", "Sailor Moon", false, ProductType.COSPLAY,List.of("S","M","L"), 3, 1000d);
            productService.saveProduct(sailorJupiter);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Boku no Hero
            Product cosplayMHADeku = new Product("Deku set", "Deku Costume, incluye trade de cuerpo completo, cinto, guantes, rodilleras, máscara y zapatos", "https://i.imgur.com/7WpevQq.png", " My Hero Academy", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 2000d);
            productService.saveProduct(cosplayMHADeku);

            Product cosplayMHATodoroki = new Product("Todoroki set", "Todoroki Costume, incluye traje de cuerpo completo y peluca", "https://i.imgur.com/7JmQOoj.png", " My Hero Academy", false, ProductType.COSPLAY, List.of("S","M","L"), 20, 1000d);
            productService.saveProduct(cosplayMHATodoroki);

            Product cosplayAllMight = new Product("All Might set", "All Might Costume, incluye traje de cuerpo completo, guantes y capa", "https://i.imgur.com/s7ydIuT.png", " My Hero Academy", false, ProductType.COSPLAY,List.of("S","M","L"), 11, 1000d);
            productService.saveProduct(cosplayAllMight);

            Product cosplayTooru = new Product("Tooru set", "Tooru Costume, incluye camisa, corbata, traje, pollera tableada y medias 3/4", "https://i.imgur.com/OyOYh4u.png", " My Hero Academy", false, ProductType.COSPLAY,List.of("S","M","L"), 8, 1100d);
            productService.saveProduct(cosplayTooru);

            Product cosplayUraraka = new Product("Uraraka set", "Uraraka costume, incluye traje de cuerpo completo y peluca", "https://i.imgur.com/oCUnc6J.png", " My Hero Academy", false, ProductType.COSPLAY,List.of("S","M","L"), 13, 1000d);
            productService.saveProduct(cosplayUraraka);

            Product cosplayBakugou = new Product("Bakugou set", "Bakugou costume, incluye traje de cuerpo completo, guantes, máscara y arnés", "https://i.imgur.com/Ggxiscq.png", " My Hero Academy", false, ProductType.COSPLAY,List.of("S","M","L"), 20, 800d);
            productService.saveProduct(cosplayBakugou);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Dragon Ball
            Product vegeta = new Product("Vegetta set", "Traje de Vegetta, incluye traje de cuerpo completo, pechera y botas", "https://i.imgur.com/28pD4Km.png", "Dragon Ball", false, ProductType.COSPLAY, List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(vegeta);

            Product bulma = new Product("Bulma set", "Traje de Bulma, incluye vestido, zapatillas, guantes y riñonera", "https://i.imgur.com/YkTlCWb.png", "Dragon Ball", false, ProductType.COSPLAY,List.of("S","M","L"), 16, 1200d);
            productService.saveProduct(bulma);

            Product gokuSSJ = new Product("goku set", "Goku Dragon Ball Super, incluye traje de cuerpo completo, cinto, botas y muñequeras", "https://i.imgur.com/IuxmPVO.png", "Dragon Ball", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(gokuSSJ);

            Product Milk = new Product("Milk set", "Traje de Milk (Chichi), incluye vestido", "https://i.imgur.com/Hxr7Vix.png", "Dragon Ball", false, ProductType.COSPLAY,List.of("S","M","L"), 10, 800d);
            productService.saveProduct(Milk);

            Product gohanSJJ = new Product("Gohan set", "Traje de Gohan, incluye traje de cuerpo completo, cinturón y capa con hombreras", "https://i.imgur.com/qfyUL9M.png", "Dragon Ball", false, ProductType.COSPLAY, List.of("S","M","L"), 15, 1300d);
            productService.saveProduct(gohanSJJ);

            Product trunks = new Product("Trunks set", "Traje de Trunks, incluye remera, pantalón, conto, chaqueta y portador de espadas", "https://i.imgur.com/XbY5NxG.png", "Dragon Ball", false, ProductType.COSPLAY,List.of("S","M","L"), 4, 1000d);
            productService.saveProduct(trunks);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            // Kimetsu no Yaiba
            Product nezuko = new Product("Nezuko set", "Nezuko set, incluye kimono, faja, sobretodo y sogas", "https://i.imgur.com/4Anmbyf.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 7, 1200d);
            productService.saveProduct(nezuko);

            Product tanjiro = new Product("Tanjiro set", "traje de Tanjiro, incluye kimono, uniforme, cinto y cintas", "https://i.imgur.com/LbNdDBX.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 15, 1200d);
            productService.saveProduct(tanjiro);

            Product mitsuri = new Product("Mitsuri set", "Traje de Misuri, incluye uniforme kimono, y cinto", "https://i.imgur.com/ZZDMzrf.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 11, 1000d);
            productService.saveProduct(mitsuri);

            Product inosuke = new Product("Inosuke set", "Traje de Inosuke, incluye peluca, pantalón decorado, botas aterciopeladas y máscara", "https://i.imgur.com/CVfkIvR.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 26, 1800d);
            productService.saveProduct(inosuke);

            Product rengoku = new Product("Rengoku set", "Traje de Rengoku, incluye uniforme, cinto, peluca, polainas y kimono", "https://i.imgur.com/hBw0AtT.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY, List.of("S","M","L"), 19, 1600d);
            productService.saveProduct(rengoku);

            Product zenitsu = new Product("Zenitsu set", "Traje de Zenitsu, incluye kimono, uniforme y polainas", "https://i.imgur.com/mcsteGK.png", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 9, 1200d);
            productService.saveProduct(zenitsu);

            Product shinobu= new Product("Shinobu set", "Traje de Shinobu, incluye uniforme, cinto y kimono", "https://i.imgur.com/UshO4IS.jpg", "Kimetsu no Yaiba", false, ProductType.COSPLAY,List.of("S","M","L"), 27, 1200d);
            productService.saveProduct(shinobu);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Jujutsu kaisen
            Product nobara = new Product("Nobara set", "Traje de Nobara, incluye uniforme y camisa", "https://i.imgur.com/gNed8TH.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(nobara);

            Product gojo = new Product("Gojo set", "Traje de Gojo, incluye uniforme, venda y peluca", "https://i.imgur.com/HYwoEHz.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 17, 1200d);
            productService.saveProduct(gojo);

            Product itadori = new Product("Itadori set", "Traje de Itadori, incluye uniforme, capucha, zapatos y peluca", "https://i.imgur.com/YIpKz0i.png", "Jujutsu Kaisen", false, ProductType.COSPLAY, List.of("S","M","L"), 18, 1500d);
            productService.saveProduct(itadori);

            Product okkotsu = new Product("Okkotsu set", "Traje de Okkotsu, incluye camisa, pantalón y peluca", "https://i.imgur.com/it5M658.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 6, 1200d);
            productService.saveProduct(okkotsu);

            Product megumi = new Product("Megumi  set", "Traje de Megumi, incluye uniforme, zapatos y peluca", "https://i.imgur.com/IxOo414.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1200d);
            productService.saveProduct(megumi);

            Product zenin = new Product("Zenin set", "Traje de Zenin, incluye uniforme y peluca", "https://i.imgur.com/9B7hjHd.png", "Jujutsu Kaisen", false, ProductType.COSPLAY,List.of("S","M","L"), 4, 1200d);
            productService.saveProduct(zenin);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Sword Art Online
            Product kirito = new Product("Kirito set", "Traje de Kirito, incluye remera, pantalón,sobretodo, arnés y guantes ", "https://i.imgur.com/82MNAGf.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 18, 1600d);
            productService.saveProduct(kirito);

            Product asuna = new Product("Asuna set", "Traje de Asuna,inlcuye peluca, uniforme, medias 3/4 y collar", "https://i.imgur.com/6jzahmD.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 19, 1700d);
            productService.saveProduct(asuna);

            Product klein = new Product("Klein set", "Traje de Klein, incluye kimono, chaleco, pantalón, remera y cinto", "https://i.imgur.com/Z0ZKh3f.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1300d);
            productService.saveProduct(klein);

            Product yuna = new Product("Yuna set", "Traje de Yuna, incluye vestido, medias, guantes y accesorios para el cabello", "https://i.imgur.com/eeG78mT.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 9, 1700d);
            productService.saveProduct(yuna);

            Product sinon = new Product("Sinon set", "Traje de Sinon, incluye chaqueta, remera, pantalón y arnés", "https://i.imgur.com/ac0fkyz.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 5, 1300d);
            productService.saveProduct(sinon);

            Product kiritoGGO = new Product("Kirito GGO set", "Traje de Kirito GGO, incluye pantalón, capa, cinto", "https://i.imgur.com/PmuWD5K.png", "Sword Art Online", false, ProductType.COSPLAY,List.of("S","M","L"), 3, 1000d);
            productService.saveProduct(kiritoGGO);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Bleach
            Product bleach = new Product("Bleach set", "Túnica de Bleach", "https://i.imgur.com/YsNWxni.png", "Bleach", false, ProductType.COSPLAY,List.of("S","M","L"), 24, 1000d);
            productService.saveProduct(bleach);

            Product ichigo = new Product("Ichigo set", "Túnica de Ichigo, inclute traje, máscara, guantes y peluca", "https://i.imgur.com/XHwFO3q.png", "Bleach", false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1800d);
            productService.saveProduct(ichigo);

            Product rukia= new Product("Rukia set", "Traje escolar Rukia, incluye camisa ,moño ,traje y pollera tableada", "https://i.imgur.com/b9pDMlx.png", "Bleach", false, ProductType.COSPLAY,List.of("S","M","L"), 17, 1200d);
            productService.saveProduct(rukia);

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Dororo
            Product hyakkimaru = new Product("Hyakkimaru set", "Túnica de Hyakkimaru, Dororo,incluye capa, bufanda, cinto y vendas", "https://i.imgur.com/6oWECLH.png","Dororo",false, ProductType.COSPLAY,List.of("S","M","L"), 22, 1400d);
            productService.saveProduct(hyakkimaru);

            Product mio = new Product("Mio set", "Túnica de Mio, Dororo","https://i.imgur.com/KIjcGso.png", "Dororo",false, ProductType.COSPLAY,List.of("S","M","L"), 21, 1000d);
            productService.saveProduct(mio);

            Product tahoumaru = new Product("Tahoumaru set", "Túnica de Tahoumaru, Dororo,incluye kimono y babucha ", "https://i.imgur.com/hZK9Y4Q.jpg","Dororo",false, ProductType.COSPLAY,List.of("S","M","L"), 19, 1500d);
            productService.saveProduct(tahoumaru);

            Product dororo = new Product("Dororo set", "Túnica de Dororo, incluye riñonera y collar", "https://i.imgur.com/sJYpktZ.png","Dororo",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(dororo);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Mob Psycho 100
            Product shigeo = new Product("Shigeo set", "Traje Shigeo, incluye uniforme", "https://i.imgur.com/VjMZ1pI.jpg","Mob Psycho 100",false, ProductType.COSPLAY,List.of("S","M","L"), 7, 1000d);
            productService.saveProduct(shigeo);

            Product reigen = new Product("Reigen set", "Traje Reigen, incluye uniforme", "https://i.imgur.com/WtileHc.jpg","Mob Psycho 100",false, ProductType.COSPLAY,List.of("S","M","L"), 4, 1000d);
            productService.saveProduct(reigen);

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Evangelion
            Product shinji = new Product("Shinji set", "Traje Shinji, Evangelion, incluye traje de cuerpo completo", "https://i.imgur.com/oan8VQA.png","Evangelion",false, ProductType.COSPLAY,List.of("S","M","L"), 24, 1000d);
            productService.saveProduct(shinji);

            Product asuka = new Product("Asuka set", "Traje Asukam, Evangelion, incluye traje de cuerpo completo", "https://i.imgur.com/VPnJbfH.jpg","Evangelion",false, ProductType.COSPLAY,List.of("S","M","L"), 30, 1000d);
            productService.saveProduct(asuka);

            Product rei = new Product("Rei set", "Traje Rei, Evangelion, incluye traje de cuerpo completo", "https://i.imgur.com/NkDJMs3.jpg","Evangelion",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1000d);
            productService.saveProduct(rei);

            Product misato= new Product("Misato set", "Traje Misato, Evangelion, incluye remera, short y chaqueta", "https://i.imgur.com/wcPSd79.png","Evangelion",false, ProductType.COSPLAY,List.of("S","M","L"), 6, 1200d);
            productService.saveProduct(misato);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆ //
            //Tokyo Ghoul
            Product kaneki= new Product("Kaneki set", "Traje Kaneki, incluye máscara, buzo, calza y bermuda", "https://i.imgur.com/agk47hZ.jpg","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 31, 1800d);
            productService.saveProduct(kaneki);

            Product touka= new Product("Touka set", "Traje Touka, incluye camisa, campera y short", "https://i.imgur.com/HkuRtRV.jpg","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 29, 1600d);
            productService.saveProduct(touka);

            Product rize= new Product("Rize set", "Traje Rize, incluye vestido largo y remera", "https://i.imgur.com/qnSJXXh.jpg","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 14, 1100d);
            productService.saveProduct(rize);


            Product suzuya= new Product("Suzuya set", "Traje Suzuya, incluye tiradores, camisa, pantalón tipo pescador y polainas", "https://i.imgur.com/O0gKVQ3.png","Tokyo Ghoul",false, ProductType.COSPLAY,List.of("S","M","L"), 19, 1400d);
            productService.saveProduct(suzuya);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Spy X Family
            Product anya= new Product("Anya set", "Traje Anya, incluye uniforme escolar(vestido), cananes blancos, peluca y zapatos", "https://i.imgur.com/RD75uXA.jpg","SpyXFamily",false, ProductType.COSPLAY,List.of("S","M","L"), 18, 2000d);
            productService.saveProduct(anya);

            Product loid= new Product("Loid Froge set", "Traje Loid Froge, incluye traje de vestir", "https://i.imgur.com/bMNTfnk.jpg","SpyXFamily",false, ProductType.COSPLAY,List.of("S","M","L"), 24, 1500d);
            productService.saveProduct(loid);

            Product yorFroge= new Product("Yor Froge set", "Traje Spy Yor Froge, incluye vestido y guantes", "https://i.imgur.com/OtWvoD1.jpg","SpyXFamily",false, ProductType.COSPLAY,List.of("S","M","L"), 26, 1400d);
            productService.saveProduct(yorFroge);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
                        //LOL
                        Product ahriKDA = new Product("Ahri KDA", "Ahri KDA, League of Legends. Incluye peluca, traje, zapatos y prensas", "https://i.imgur.com/Z9TY0MM.jpg", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 17, 1800);
                        productService.saveProduct(ahriKDA);

                        Product akaliKDA = new Product("Akali KDA", "Akali KDA, League of Legends. Incluye chaqueta, top y calzas", "https://i.imgur.com/suvHkod.jpg", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 15, 1200);
                        productService.saveProduct(akaliKDA);

                        Product jinx = new Product("Jinx Arcane", "Jinx Arcane, League of Legends. Incluye", "https://i.imgur.com/NYF4RlL.jpg", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(jinx);

                        Product vi = new Product("Vi Arcane", "Vi Arcane, League of Legends. Incluye chaqueta, remrera, pantalón, cinto, peluca y botas", "https://i.imgur.com/NcU8zMn.png", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(vi);

                        Product rakan = new Product("Rakan", "Rakan, League of Legends. Incluye traje, capa de plumas, guantes largos y sogas", "https://i.imgur.com/9qk4rfH.png", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(rakan);

                        Product xayah = new Product("Xayah", "Xayah, League of Legends. Incluye traje, capa de plumas, capucha con accesorio y guantes", "https://i.imgur.com/9Z8ehXu.jpg", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(xayah);

                        Product yasuo = new Product("Yasou", "Yasou, League of Legends. Incluye espada, guantes de armadura, pantalones, botas, capa, hombrera y sogas", "https://i.imgur.com/Imvo1PF.png", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(yasuo);

                        Product qiyana = new Product("Qiyana True Damage", "Quiyana, League of Legends. Incluye traje, ", "https://i.imgur.com/6dQXvk0.png", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(qiyana);

                        Product yona = new Product("Yona Spirit Blossom", "Yona, League of Legends. Incluye túnica y sobretodo", "https://i.imgur.com/cttwgFh.png", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(yona);

                        Product ashe = new Product("Ashe", "Ashe, League of Legends. Incluye traje, capa, gorra y cinto", "https://i.imgur.com/ca4n3bq.png", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(ashe);

                        Product bagre = new Product("Thamkench", "Thamkench, League of Legends. Incluye gorrito fifi", "https://i.imgur.com/VGcaYH4.png", "League of Legends", false, ProductType.COSPLAY, List.of("S","M","L"), 25, 1200);
                        productService.saveProduct(bagre);
   // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
  // Clothes

            //remeras

                    //remeras origami
            Product shirtVandalOriBlue = new Product("Remera Origami Blanca", List.of("blue"), "Remera Origami, VANDALISM.R.O edition. 100% Algodón", "https://i.imgur.com/2O3xyuG.png", "https://i.imgur.com/chmMZIb.png", "Origami Boom", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 750);
            productService.saveProduct(shirtVandalOriBlue);

            Product shirtVandalOriBlack = new Product ("Remera Origami Negra", List.of("black"),"Remera Origami, VANDALISM.R.O edition. 100% Algodón","https://i.imgur.com/2O3xyuG.png","https://i.imgur.com/2O3xyuG.png","Origami Boom",ClothesType.T_SHIRT,false,ProductType.CLOTHES,List.of("S","M","L"),10,750);
            productService.saveProduct(shirtVandalOriBlack);

            Product shirtVandalOriRed = new Product("Remera Origami Roja", List.of("red"), "Remera Origami, VANDALISM.R.O edition. 100% Algodón", "https://i.imgur.com/30ihABU.png", "https://i.imgur.com/VcWLysG.png", "Origami Boom", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","M","L"), 13, 750);
            productService.saveProduct(shirtVandalOriRed);

            Product shirtVandalOriGray = new Product("Remera Origami Gris", List.of("gray"), "Remera Origami, VANDALISM.R.O edition. 100% Algodón", "https://i.imgur.com/wXT712h.png", "https://i.imgur.com/NLjZX6e.png", "Origami Boom", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 750);
            productService.saveProduct(shirtVandalOriGray);

            Product shirtVandalOriPink = new Product("Remera Origami Rosa", List.of("purple"), "Remera Origami, VANDALISM.R.O edition. 100% Algodón", "https://i.imgur.com/VkKeubu.png", "https://i.imgur.com/zWYf83T.png", "Origami Boom", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","M","L"), 11, 750);
            productService.saveProduct(shirtVandalOriPink);

                //remeras Lau
            Product remeraGoku = new Product("Remera Goku", List.of("black"), "Remera de Goku SSJ, 100% algodón", "https://i.imgur.com/2vdgo7p.jpg", "https://i.imgur.com/TeCQYHx.jpg", "Dragon Ball", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 16, 600);
            productService.saveProduct(remeraGoku);

            Product remeraNaruto = new Product("Remera Naruto", List.of("black"), "Remera de Naruto, 100% algodón", "https://i.imgur.com/Zy3Ztsc.jpg", "https://i.imgur.com/Zy3Ztsc.jpg", "Naruto theme", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 17, 600);
            productService.saveProduct(remeraNaruto);

            Product remeraSasuke = new Product("Remera Sasuke", List.of("black"), "Remera de Sasuke, 100% algodón","https://i.imgur.com/Mx0crk3.jpg", "https://i.imgur.com/Mx0crk3.jpg", "Naruto theme", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 20, 600);
            productService.saveProduct(remeraSasuke);

            Product remeraKakashi= new Product("Remera kakashi", List.of("black"), "Remera de Kakashi neko, 100% algodón", "https://i.imgur.com/vX3sMGT.jpg", "https://i.imgur.com/r6WnPKt.jpg", "Naruto theme", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 21, 600);
            productService.saveProduct(remeraKakashi);

            Product remeratodoroki = new Product("Remera Todoroki", List.of("blue"), "Remera marmolada de Todoroki, 100% algodón","https://i.imgur.com/RLjawjx.jpg", "https://i.imgur.com/DIhrFVV.jpg", "BNHA", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 17, 600);
            productService.saveProduct(remeratodoroki);

            Product remeraBakugou = new Product("Remera Todoroki", List.of("orange"), "Remera marmolada de Bakugou, 100% algodón","https://i.imgur.com/5LpsdVG.jpg", "https://i.imgur.com/CHMXE0I.jpg", "BNHA", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 17, 600);
            productService.saveProduct(remeraBakugou);

            Product remeraAllMight = new Product("Remera All Might", List.of("black"), "Remera de All Might, 100% algodón","https://i.imgur.com/hgxnKYI.jpg", "https://i.imgur.com/Lpcext8.jpg", "BNHA", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 13, 600);
            productService.saveProduct(remeraAllMight );

            Product remeraJujutsu = new Product("Remera Gojo", List.of("purple"), "Remera marmolada de Gojo, 100% algodón","https://i.imgur.com/u9guu3U.jpg", "https://i.imgur.com/NLHwsxv.jpg", "Jujutsu Kaisen", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 19, 600);
            productService.saveProduct(remeraJujutsu);

            Product remeraJujutsuChibi = new Product("Remera Jujutsu Kaisen", List.of("black"), "Remera Jujutsu Chibi, 100% algodón","https://i.imgur.com/mG2r3eu.jpg", "https://i.imgur.com/BrFa41j.jpg", "Jujutsu Kaisen", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 17, 600);
            productService.saveProduct(remeraJujutsuChibi);

            Product camisaBleach = new Product("Remera Bleach", List.of("black"), "Remera de Bleach, 100% algodón","https://i.imgur.com/dIKoJl3.jpg", "https://i.imgur.com/L3gChjW.jpg", "Bleach", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 11, 600);
            productService.saveProduct(camisaBleach);

            Product remeraSNK = new Product("Remera Shingeki no Kyojin", List.of("black"), "Remera de Shingeki no Kyojin, 100% algodón","https://i.imgur.com/dCpBiw6.jpg", "https://i.imgur.com/LEVWuuU.jpg", "Shingeki no Kyojin", ClothesType.T_SHIRT, false, ProductType.CLOTHES, List.of("S","L","M"), 24, 600);
            productService.saveProduct(remeraSNK);

            Product hoodieSNK = new Product("Hoodie Shingeki no Kyojin", List.of("black"), "Hoodie de Shingeki no Kyojin,Titan Acorazado, 100% algodón","https://i.imgur.com/5EdzXhj.jpg", "https://i.imgur.com/5EdzXhj.jpg", "Shingeki no Kyojin", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","L","M"), 17, 800);
            productService.saveProduct(hoodieSNK);

            Product hoodiePikachu = new Product("Hoodie Pikachu", List.of("yellow"), "Hoodie de Pikachu, Pokemón, mangas rosas patel y torso amarillo pastel. Lana","https://i.imgur.com/O33U8JM.jpg", "https://i.imgur.com/O33U8JM.jpg", "Pokemón", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","L","M"), 18, 800);
            productService.saveProduct(hoodiePikachu);

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆

            //buzos  resolucion 320 y 540(aclarar)

            Product hoodieHyakkimaru = new Product("Hoodie Hyakkimaru", List.of("gray"), "Hoodie de Hyakkimaru, 100% algodón.", "https://i.imgur.com/fvOrEvY.png","https://i.imgur.com/fvOrEvY.png", "Dororo", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 19, 800);
            productService.saveProduct(hoodieHyakkimaru);

            Product hoodiePsycho = new Product("Hoodie Psycho", List.of("gray"), "Hoodie Mob Psycho 100", "https://i.imgur.com/YptBDwF.png", "https://i.imgur.com/YptBDwF.png", "Mob Psycho 100", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 800);
            productService.saveProduct(hoodiePsycho);

            //hoodies origami vansalism
            Product hoodieVandalOriBlack = new Product("Hoodie Vandalims Black ", List.of("black"), "Hoodie negro 100%, Vandalism Origami edition", "https://i.imgur.com/kIMBu2N.jpg", "https://i.imgur.com/2x5GTnt.jpg", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 7, 850);
            productService.saveProduct(hoodieVandalOriBlack);//viene en negro y blanco

            Product hoodieVandalOriBlanco = new Product("Hoodie Vandalims Blanco", List.of("white"), "Hoodie blanco 100%, Vandalism Origami edition", "https://i.imgur.com/Kk1YT8I.jpg", "https://i.imgur.com/qsn39Bk.jpg", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 850);
            productService.saveProduct(hoodieVandalOriBlanco);//viene en negro y blanco

            //hoodie origami logo
             Product hoodieLogoBlack = new Product("Hoodie Origami", List.of("black"), "Hoodie negro 100% algodón, Origami edition", "https://i.imgur.com/kuewxMn.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 20, 850);
             productService.saveProduct(hoodieLogoBlack);

             Product hoodieMiniLogoBlack = new Product("Hoodie Origami", List.of("black"), "Hoodie negro 100% algodón, Origami  edition", "https://i.imgur.com/aTjM9Qy.png", "https://i.imgur.com/aTjM9Qy.png", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 6, 850);
             productService.saveProduct(hoodieMiniLogoBlack);

             Product hoodieLogoWhite = new Product("Hoodie Origami", List.of("white"), "Hoodie blanco 100% algodón, Origami edition", "https://i.imgur.com/mTdbjYu.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 9, 850);
             productService.saveProduct(hoodieLogoWhite);

             Product hoodieLogoRed = new Product("Hoodie Origami", List.of("red"), "Hoodie rojo 100% algodón, Origami edition", "https://i.imgur.com/XqbbHc6.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 16, 850);
             productService.saveProduct(hoodieLogoRed);

             Product hoodieLogoPink = new Product("Hoodie Origami", List.of("purple"), "Hoodie rosa 100% algodón, Origami edition", "https://i.imgur.com/U9xtsc2.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 850);
             productService.saveProduct(hoodieLogoPink);

             Product hoodieLogoBlue = new Product("Hoodie Origami", List.of("blue"), "Hoodie azul 100% algodón, Origami edition", "https://i.imgur.com/ZXwlMFz.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 13, 850);
             productService.saveProduct(hoodieLogoBlue);

             Product hoodieOriyellow = new Product("Hoodie Origami", List.of("gray"), "Hoodie azul 100% algodón, Origami Yellow edition", "https://i.imgur.com/KJzVesd.png", "https://i.imgur.com/Mb0RMfh.png", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 13, 850);
             productService.saveProduct(hoodieOriyellow);


             //hoodieMultiOri
             Product hoodieMultiOriGrey = new Product("Hoodie Logo Origami", List.of("gray"), "Hoodie gris con logos negros Origami, 100% algodón, Origami edition", "https://i.imgur.com/z29hH8w.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 21, 850);
             productService.saveProduct(hoodieMultiOriGrey);

             Product hoodieMultiOriWhite = new Product("Hoodie Logo Origami", List.of("white"), "Hoodie blanco con logos negros Origami, 100% algodón, Origami edition", "https://i.imgur.com/4fTcNco.png", "", "Origami", ClothesType.HOODIE, false, ProductType.CLOTHES, List.of("S","M","L"), 17, 850);
             productService.saveProduct(hoodieMultiOriWhite);

           // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆

            //pantalones  resoluciuon 320 y 540(aclarar)
            Product vandalTrousersWhite = new Product("Vandalismo.R.O Trousers", List.of("white"), "Babucha blanca, VANDALISM.R.O edition", "https://i.imgur.com/Zf8d7fu.png", "https://i.imgur.com/Wf3Irr4.png", "Origami", ClothesType.TROUSER, true, ProductType.CLOTHES, List.of("S","M","L"), 10, 900);
            productService.saveProduct(vandalTrousersWhite);//viene en blanco y en negro

            Product vandalTrousersBlack = new Product("Vandalismo.R.O Trousers", List.of("black"), "Babucha negra, VANDALISM.R.O edition", "https://i.imgur.com/Vhd8IaS.png", "https://i.imgur.com/mh2C0WF.png", "Origami", ClothesType.TROUSER, true, ProductType.CLOTHES, List.of("S","M","L"), 18, 900);
            productService.saveProduct(vandalTrousersBlack);//viene en blanco y en negro

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
            //Zapatillas, resoluciuon 320 y 540(aclarar)
            Product vandalNike = new Product("Origami Nikes", List.of("black","white"), "Zapatillas Origami&Nike crossover, special edition", "https://i.imgur.com/cd3PwOW.png", "https://i.imgur.com/cd3PwOW.png", "Origami", ClothesType.SNEAKER,true, ProductType.CLOTHES, List.of("36","38","40","42"), 24, 1050);
            productService.saveProduct(vandalNike);

            Product vandalNikeBlack = new Product("Origami Black Nikes", List.of("black","white"), "Zapatillas Origami&Nike crossover, special edition", "https://i.imgur.com/EP9I5SU.png", "https://i.imgur.com/EP9I5SU.png", "Origami", ClothesType.SNEAKER, true, ProductType.CLOTHES, List.of("36","38","40","42"), 17, 1050);
            productService.saveProduct(vandalNikeBlack);

            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
               //camperas
            Product jacketVandalOriBlack = new Product("Origami Black Jacket", List.of("black"), "Campera negra, VANDALISM.R.O edition", "https://i.imgur.com/8PISoHI.png", "https://i.imgur.com/EfrJULR.png", "Origami", ClothesType.JACKET, true, ProductType.CLOTHES, List.of("S","M","L"), 25, 1000);
            productService.saveProduct(jacketVandalOriBlack );

            Product jacketVandalOriWhite = new Product("Origami White Jacket", List.of("white"), "Campera blanca, VANDALISM.R.O edition", "https://i.imgur.com/3e8ssJq.png", "https://i.imgur.com/u5VaFod.png", "Origami", ClothesType.JACKET, true, ProductType.CLOTHES, List.of("S","M","L"), 30, 1000);
            productService.saveProduct(jacketVandalOriWhite);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
                //Gorros
            Product hatOrigamiBlack = new Product("Origami Black Hat", List.of("black"), "Gorrito negro origami", "https://i.imgur.com/WZJhrvW.jpg", "https://i.imgur.com/WZJhrvW.jpg", "Origami", ClothesType.HAT, true, ProductType.CLOTHES, List.of("S","M","L"), 7, 250);
            productService.saveProduct(hatOrigamiBlack);

            Product hatOrigamiWhite = new Product("Origami White Hat", List.of("white"), "Gorrito blanco origami", "https://i.imgur.com/hpqW6Qf.png", "https://i.imgur.com/hpqW6Qf.png", "Origami", ClothesType.HAT, true, ProductType.CLOTHES, List.of("S","M","L"), 15, 250);
            productService.saveProduct(hatOrigamiWhite);
            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆
                //LOL


            // __________-------_______-------_______--------// <3 uwu ☆*: .｡. o(≧▽≦)o .｡.:*☆

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
            ProductList productList1 = new ProductList(remeraSNK,4,20,invoice);
            ProductlistService.saveProductList(productList1);

            //
            Invoice invoice1 = new Invoice(client1, PaymentMethods.DEBIT, ShippingType.SHOP_PICKUP, "B0001-00000025", 500d, LocalDateTime.now());
            invoiceService.saveInvoices(invoice1);




        };
    }


}
