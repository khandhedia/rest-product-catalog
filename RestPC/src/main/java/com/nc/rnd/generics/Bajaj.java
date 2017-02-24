package com.nc.rnd.generics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Bajaj extends Scooter {

    String variant;
    public Bajaj(String variant) {
        super("Bajaj");
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }
}
