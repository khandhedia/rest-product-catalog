package com.nc.rnd.statics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Car extends com.nc.rnd.generics.Vehicle {

    public String make;

    public Car(String make) {
        super("Car");
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    //@Override This will throw exception.. because it is not overriding - it is just hiding/shadowing
    public static Vehicle createVehicle(String name)
    {
        System.out.println("Execution from Car class");
        return new Vehicle(name);
    }
}
