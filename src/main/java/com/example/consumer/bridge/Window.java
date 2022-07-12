package com.example.consumer.bridge;

public class Window<T>  implements Driver<T>{


    @Override
    public void addImage(T t) {
        System.out.println(t + "WD add image");
    }

    @Override
    public void deleteImage(T t) {
        System.out.println(t + "WD delete image");
    }

}
