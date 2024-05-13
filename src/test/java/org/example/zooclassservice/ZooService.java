package org.example.zooclassservice;

public class ZooService {
    public static void main(String[] args) {
        Animal dog = new Dog("Tuzic");
        Dog secondDog = new Dog("Tuzic2");

        Animal cat = new Cat ("Murzic");
        Cat secondCat = new Cat ("Murzic2");

                dog.eat();



                cat.eat();

                cat.makeSound();
                secondCat.makeSound();
                secondDog.makeSound();






    }
}
