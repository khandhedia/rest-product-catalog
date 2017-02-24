package com.nc.rnd.decorator.decoratorimpementation;

import com.nc.rnd.decorator.component.Currency;
import com.nc.rnd.decorator.decorator.CurrencyDecorator;

/**
 * Created by nirk0816 on 2/8/2017.
 */
public class SGDollar extends CurrencyDecorator {

    Currency plainCurrencyObject;

    public SGDollar(Currency plainCurrencyObject) {
        this.plainCurrencyObject = plainCurrencyObject;
    }

    @Override
    public String getDecoratedDollarDescription() {
        return this.plainCurrencyObject.getDescription()+" Deocrated SGD Description";
    }

    @Override
    public void setAmount(long amount) {
        this.setAmount(amount);
    }
}
