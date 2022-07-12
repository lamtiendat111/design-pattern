package com.example.consumer.bridge;

public class ActionDriver<T> implements Action<T> {

    private Driver driver;

    public ActionDriver(Driver driver){
        this.driver = driver;
    }

    @Override
    public void addImage(T t) {
        driver.addImage(t);
    }
}
