package com.nc.rnd.generics;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class Hero extends Scooter {

    String variant;
    public Hero(String variant) {
        super("Hero");
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }
}
