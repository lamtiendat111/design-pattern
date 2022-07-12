package com.example.consumer.adapter;

public class PaymentProcessorImpl implements PaymentProcessor {
    @Override
    public void pay(int dollarrs) {
        System.out.println("Da thanh toan dollar:" +dollarrs);
    }
}
