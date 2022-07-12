package com.example.consumer.auth;

public class Otp {
    private String code;
    private long timeExpire;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(long timeExpire) {
        this.timeExpire = timeExpire;
    }
}
