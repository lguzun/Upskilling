package org.example.zooclassservice;

public class Cat extends Animal implements AnimalInterface{

    public Cat(String name){
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Cat " + getName() + " says: Miau!");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating fish");
    }
}

