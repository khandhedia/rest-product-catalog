package com.nc.rnd.decorator.componentimplementation;

import com.nc.rnd.decorator.component.Currency;

/**
 * Created by nirk0816 on 2/8/2017.
 */
public class Dollar extends Currency {

    public Dollar() {
        this.description = "Dollar";
    }

    @Override
    public void setAmount(long amount) {
        this.setAmount(amount);
    }
}
