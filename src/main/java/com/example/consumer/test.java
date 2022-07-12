package com.example.consumer;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static class Product{
        private boolean available;

        private String name;

        public Product(boolean b, String name)
        {
            available = b;
            this.name = name;
        }
    }

    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int rev = 0;

        while(x > 0){
            rev = rev *10 + x%10;
            x= x /10;
        }
        return x == rev ? true: false;
    }

    public static int[] constructArray(int n, int k) {
        Map<Integer,Integer> temp = new HashMap<>();
        int[] result = new int[n];
        int max = n;
        for(int i = 0 ; i <= n/2; i++){
            //kiem tra so co trong temp chua ?
            // neu co la mat roi khong lay nua
            int one = i + 1 ;
            int two = one + k;
            while(two > n || temp.containsKey(two)){
                two = max--;
            }
            while (temp.containsKey(one)){
                one++;
                two = one + k;
                while(two > n || !temp.containsKey(two)){
                    two = max--;
                    if(one >= two)
                        break;
                }
            }
            if(!temp.containsKey(one)){
                result[i*2] = one;
                temp.put(one,1);
                if(!temp.containsKey(two)){
                    result[i*2+1] = two;
                    temp.put(two,1);
                }
                else{
                    two = one+1;
                    if(two <= n){
                        if(!temp.containsKey(two)){
                            result[i*2+1] = two;
                            temp.put(two,1);
                        }
                    }
                }

            }
        }
        return result;
    }
    public static void main(String[] args) {
       constructArray(5,4);
//        isPalindrome(121);
//        int x = -123;
////        if(x < 0)
////            return false;
//
//        String input = String.valueOf(x);
//
//
//
//            List<Product> products = Arrays.asList(
//                new Product(true,"A"),
//                new Product(false,"B"),
//                new Product(true,"F"),
//                new Product(false,"D"),
//                new Product(true,"A"),
//                new Product(false,"Z")
//        );
//        Collections.sort(products, new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                boolean p1Sellable;
//                boolean p2Sellable;
//
//                p1Sellable = p1.available;
//                p2Sellable = p2.available;
//
//                if (p1Sellable != p2Sellable) {
//                    return p1Sellable ? -1 : 1;
//                }
//
//                String titleOption1 = p1.name;
//                String titleOption2 = p2.name;
//                if (!ObjectUtils.equals(titleOption1, titleOption2)) {
//                    if (StringUtils.isEmpty(titleOption1)) {
//                        return 1;
//                    } else if (StringUtils.isEmpty(titleOption2)) {
//                        return -1;
//                    } else {
//                        return titleOption1.compareTo(titleOption2);
//                    }
//                }
//
//                return titleOption1.compareTo(titleOption2);
//            }
//        });
//
//        products.forEach(y->{
//            System.out.println(y.available + " :" +y.name);
//        });
    }

    public static boolean checkCharacter(String input){
        Pattern pattern = Pattern.compile("[\"|&;$%@'<>()+\r\n,=\\\\\\\\\\\\\\\\(.+?)\\\\\\\\(.*)]");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
