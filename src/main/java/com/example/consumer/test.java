package com.example.consumer;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public static void main(String[] args) {
        isPalindrome(121);
        int x = -123;
//        if(x < 0)
//            return false;

        String input = String.valueOf(x);



            List<Product> products = Arrays.asList(
                new Product(true,"A"),
                new Product(false,"B"),
                new Product(true,"F"),
                new Product(false,"D"),
                new Product(true,"A"),
                new Product(false,"Z")
        );
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                boolean p1Sellable;
                boolean p2Sellable;

                p1Sellable = p1.available;
                p2Sellable = p2.available;

                if (p1Sellable != p2Sellable) {
                    return p1Sellable ? -1 : 1;
                }

                String titleOption1 = p1.name;
                String titleOption2 = p2.name;
                if (!ObjectUtils.equals(titleOption1, titleOption2)) {
                    if (StringUtils.isEmpty(titleOption1)) {
                        return 1;
                    } else if (StringUtils.isEmpty(titleOption2)) {
                        return -1;
                    } else {
                        return titleOption1.compareTo(titleOption2);
                    }
                }

                return titleOption1.compareTo(titleOption2);
            }
        });

        products.forEach(y->{
            System.out.println(y.available + " :" +y.name);
        });
    }
}
