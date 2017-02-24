package com.nc.rnd.decorator.client;

import com.nc.rnd.decorator.component.Currency;
import com.nc.rnd.decorator.componentimplementation.Dollar;
import com.nc.rnd.decorator.componentimplementation.Rupee;
import com.nc.rnd.decorator.decorator.CurrencyDecorator;
import com.nc.rnd.decorator.decoratorimpementation.SGDollar;
import com.nc.rnd.decorator.decoratorimpementation.USDollar;

/**
 * Created by nirk0816 on 2/8/2017.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        DecoratorTest decoratorTest = new DecoratorTest();

        //Testing Regular objects
        Currency regularDollar = new Dollar();
        Currency regularRupee = new Rupee();

        System.out.println(regularDollar.getDescription());
        System.out.println(regularRupee.getDescription());

        //Testing Decorated objects
        CurrencyDecorator decoratedSGDollar = new SGDollar(regularDollar);
        CurrencyDecorator decoratedUSDollar = new USDollar(regularDollar);

        System.out.println(decoratedSGDollar.getDecoratedDollarDescription());
        System.out.println(decoratedUSDollar.getDecoratedDollarDescription());

    }
}
