package com.nc.rnd.decorator.component;

/**
 * Created by nirk0816 on 2/8/2017.
 */


//This is the existing abstract class.
// One of its implementation (objects/instances) require enhanced behavior.
// But, we cannot  modify this class, to meet requirements of a specific/or a couple of objects (instances) of this class

public abstract class Currency {

    long amount;

    protected String description = "Unknown Currency";

    public String getDescription(){
        return description;
    }

    public abstract void setAmount (long amount);

}
