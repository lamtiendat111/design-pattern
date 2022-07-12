package com.example.consumer.templateMethod;

public class LaptopManufacturer extends Computermanufacturer {
    @Override
    void addHardDisk() {
        System.out.println("SSD");
    }

    @Override
    void addRam() {
        System.out.println("Ram 16GB");
    }

    @Override
    void addKeyboard() {
        System.out.println("Keyboard full color");
    }
}
