package com.nc.rnd.generics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Scooter extends Vehicle{

    public String make;

    public Scooter(String make) {
        super("Scooter");
        this.make = make;
    }

    public String getMake() {
        return make;
    }
}
