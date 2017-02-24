package com.nc.rnd.decorator.decoratorimpementation;

import com.nc.rnd.decorator.component.Currency;
import com.nc.rnd.decorator.decorator.CurrencyDecorator;

/**
 * Created by nirk0816 on 2/8/2017.
 */
public class USDollar extends CurrencyDecorator {

    Currency plainCurrencyObject;

    public USDollar(Currency plainCurrencyObject) {
        this.plainCurrencyObject = plainCurrencyObject;
    }

    @Override
    public String getDecoratedDollarDescription() {
        return this.plainCurrencyObject.getDescription()+" Deocrated USD Description";
    }

    @Override
    public void setAmount(long amount) {
        this.setAmount(amount);
    }
}
