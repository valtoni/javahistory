package org.github.valtoni.java8;

interface Vehicle {

    void accelerate();

    // Default method
    default void honk() {
        System.out.println("Honking!");
    }

}

class Car implements Vehicle {

    public void accelerate() {
        System.out.println("Car accelerate");
    }

}


public class DefaultMethodExample {

    public static void main(String[] args) {
        Car car = new Car();
        car.accelerate();
        car.honk();
    }

}
