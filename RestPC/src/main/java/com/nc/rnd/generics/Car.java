package com.nc.rnd.generics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Car extends Vehicle {

    public String make;

    public Car(String make) {
        super("Car");
        this.make = make;
    }

    public String getMake() {
        return make;
    }
}
