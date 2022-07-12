package com.example.consumer.templateMethod;

public class DesktopManufacturer extends Computermanufacturer {
    @Override
    void addHardDisk() {
        System.out.println("HDD");
    }

    @Override
    void addRam() {
        System.out.println("Ram 8GB");
    }

    @Override
    void addKeyboard() {
        System.out.println("Keyboard normal");
    }
}
