package com.example.consumer.bridge;

public class Client {

    public static void main(String[] args) {
        ActionDriver driver = new ActionDriver(new IOS());
        driver.addImage("png");

        ActionDriver driver2 = new ActionDriver(new Window());
        driver2.addImage("png");
    }
}
