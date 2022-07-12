package com.example.consumer.bridge;

public interface Driver<T> {

    void addImage(T t);

    void deleteImage(T t);
}
