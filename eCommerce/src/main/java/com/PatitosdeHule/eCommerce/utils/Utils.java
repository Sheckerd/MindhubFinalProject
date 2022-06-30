package com.PatitosdeHule.eCommerce.utils;
import java.util.ArrayList;
import java.util.List;
public final class Utils {

   public static String getRandomNumber(int min, int max) {

           List<String> cont = new ArrayList<>();
           Integer numberss;
           do {
               numberss = (int) ((Math.random() * (max - min)) + min);


           } while (cont.contains(numberss));

           String formatString = String.format("%%0%dd", 8);

           String formattedString = String.format(formatString, numberss);

           cont.add(formattedString);

           return formattedString;
   }

}
