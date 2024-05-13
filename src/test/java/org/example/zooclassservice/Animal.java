package org.example.zooclassservice;

public abstract class Animal implements AnimalInterface {
    private String name;
    public Animal (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void eat();
}
