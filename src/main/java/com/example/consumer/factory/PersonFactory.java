package com.example.consumer.factory;

public class PersonFactory {
    public Person createPerson(String type)
    {
        Person p = null;
        switch (type)
        {
            case "Female":  p = new Female();break;
            case "Male":  p = new Male();break;
        }
        return p;
    }
}
