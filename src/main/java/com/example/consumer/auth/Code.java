package com.example.consumer.auth;

import java.util.Locale;
import java.util.UUID;

public class Code {
    private static final int CONFIG_TIME = 30;
    private static Otp otp;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(generateOtp());
        System.out.println(checkTimeExpired());;
        System.out.println(otp.getTimeExpire());;
        Thread.sleep(1000*30);
        System.out.println(checkTimeExpired());;
        System.out.println(otp.getTimeExpire());;
        ;
    }

    public static String generateOtp() {
        String code = UUID.randomUUID().toString().toUpperCase(Locale.ROOT).substring(0, 6);
        otp = new Otp();
        otp.setCode(code);
        otp.setTimeExpire(System.currentTimeMillis() + CONFIG_TIME);
        return code;
    }

    public static boolean checkTimeExpired() {
        try {
            if (otp.getTimeExpire() < System.currentTimeMillis())
                return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
