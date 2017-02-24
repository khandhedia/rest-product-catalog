package com.nc.rnd.decorator.decorator;

import com.nc.rnd.decorator.component.Currency;

/**
 * Created by nirk0816 on 2/8/2017.
 */
public abstract class CurrencyDecorator extends Currency{

    public abstract String getDecoratedDollarDescription();

}
