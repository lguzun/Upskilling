package org.example.zooclassservice;

public class Dog extends Animal implements AnimalInterface{

    public Dog(String name){
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Dog " + getName() + " says: Wof!");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating bones");
    }
}

