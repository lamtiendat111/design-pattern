package com.example.consumer.templateMethod;

public abstract class Computermanufacturer {
    void buildComputer(){
        addHardDisk();
        addRam();
        addKeyboard();
    }

    abstract void addHardDisk();
    abstract void addRam();
    abstract void addKeyboard();
}
