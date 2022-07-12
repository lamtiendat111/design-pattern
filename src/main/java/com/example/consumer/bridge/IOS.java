package com.example.consumer.bridge;

public class IOS<T>  implements Driver<T>{


    @Override
    public void addImage(T t) {
        System.out.println(t + "IOS add image");
    }

    @Override
    public void deleteImage(T t) {
        System.out.println(t + "IOS delete image");
    }

}
