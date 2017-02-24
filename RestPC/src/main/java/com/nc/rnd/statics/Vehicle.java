package com.nc.rnd.statics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Vehicle {

    private String type;
    public Vehicle(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Vehicle createVehicle(String name)
    {
        System.out.println("Execution from Vehicle class");
        return new Vehicle(name);
    }
}
