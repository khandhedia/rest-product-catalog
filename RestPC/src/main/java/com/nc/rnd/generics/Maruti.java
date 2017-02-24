package com.nc.rnd.generics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Maruti extends com.nc.rnd.statics.Car {

    String variant;
    public Maruti(String variant) {
        super("Maruti");
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }
}
