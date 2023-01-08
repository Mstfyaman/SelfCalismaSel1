package com.amazon.regex;

import com.amazon.utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordControlWithRegex {

   static boolean control ;

    public static void main(String[] args) {

        String password = "bsHaaaF2.-_?=";



        for (int i = 0; i <10 ; i++) {
            passwordControl(generateRandomString2());
          //  BrowserUtils.waitFor(1);
            if (control){
                System.out.println(generateRandomString2());
                control=false;
            }
        }


       // System.out.println(subString("ford"));

    }



    public static void passwordControl(String password){

   // String regex =   "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,16}$";
    String regex =  "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d\\p{Punct}]{8,16}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);


        if (matcher.matches()){
            System.out.println("Password is valid");
        }else {
            control=true;
            System.out.println("Password is NOT Valid");
        }



    }

    //--------------------------------------------------------------


    public static String generateRandomString2() {
        // Noktalama işaretleri, büyük harfler, küçük harfler ve rakamları içeren bir karakter dizisi oluşturun
        char[] characters = "!@#$%^&*()_+-=[]{}|;':,.<>?".toCharArray();
        char[] upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] lowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digits = "0123456789".toCharArray();

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Rastgele uzunlukta bir string oluşturun (8 ile 16 arasında)
        int length = 8 + random.nextInt(9);

        // String'e mutlaka büyük harf, küçük harf, rakam ve noktalama işareti ekleyin
        sb.append(characters[random.nextInt(characters.length)]);
        sb.append(upperCase[random.nextInt(upperCase.length)]);
        sb.append(lowerCase[random.nextInt(lowerCase.length)]);
        sb.append(digits[random.nextInt(digits.length)]);

        // Kalan karakterleri rastgele ekleyin
        for (int i = 4; i < length; i++) {
            int type = random.nextInt(4);
            if (type == 0) {
                sb.append(characters[random.nextInt(characters.length)]);
            } else if (type == 1) {
                sb.append(upperCase[random.nextInt(upperCase.length)]);
            } else if (type == 2) {
                sb.append(lowerCase[random.nextInt(lowerCase.length)]);
            } else {
                sb.append(digits[random.nextInt(digits.length)]);
            }
        }

        return sb.toString();
    }

    //-------------------------------------------------------------------

    public static List<String> subString(String str){ // ford
        List<String> list1 = new ArrayList<>();


        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j <= str.length()-i; j++) {
                String sub = str.substring(i,j+i);
                list1.add(sub);
            }

        }


        return  list1;
    }



}
