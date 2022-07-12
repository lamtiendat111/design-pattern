package com.example.consumer.adapter;

public class PaymentAdapter {
    public PaymentAdapter(){}
    public void pay(int rupees){
        int dollar = 100 * rupees;
        PaymentProcessorImpl paymentProcessor = new PaymentProcessorImpl();
        paymentProcessor.pay(dollar);
    }
}
