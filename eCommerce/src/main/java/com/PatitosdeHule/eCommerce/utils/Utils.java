package com.PatitosdeHule.eCommerce.utils;
import java.util.ArrayList;
import java.util.List;
public final class Utils {

   public static int getRandomNumber(int min, int max) {

            List<Integer> cont = new ArrayList<>();

            Integer numberss;
            do {
                numberss = (int) ((Math.random() * (max - min)) + min);

                if(numberss.toString().length() < max) {
                    for (int i = 0; i < max - numberss.toString().length(); i++) {
                        numberss = Integer.parseInt("0" + numberss.toString());
                        i++;
                    }
                }
            } while (cont.contains(numberss));

            cont.add(numberss);
            return numberss;
        }

}
