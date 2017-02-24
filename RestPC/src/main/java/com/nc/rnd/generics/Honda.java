package com.nc.rnd.generics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Honda extends Scooter {

    String variant;
    public Honda(String variant) {
        super("Honda");
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }
}
