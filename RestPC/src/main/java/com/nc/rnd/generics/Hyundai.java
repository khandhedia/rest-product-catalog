package com.nc.rnd.generics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Hyundai extends com.nc.rnd.statics.Car {

    String variant;
    public Hyundai(String variant) {
        super("Hyundai");
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }
}
