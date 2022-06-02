package com.example.consumer.factory;

public class test {
    public static void main(String[] args) {
        PersonFactory personFactory = new PersonFactory();
        Person p = personFactory.createPerson("Male");
        p.wish("hi");
    }
}
