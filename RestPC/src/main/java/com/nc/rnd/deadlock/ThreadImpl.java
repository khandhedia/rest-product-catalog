package com.nc.rnd.deadlock;

import com.nc.rnd.BitManipulation;
import com.nc.rnd.FizzBuzz;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class ThreadImpl implements Runnable {

    @Override
    public void run() {

        method1();
        method2();


    }

    public void method1() {

        synchronized (FizzBuzz.class)
        {
            System.out.println("FizzBuzz Synchronized Lock achieved");

            synchronized (BitManipulation.class)
            {
                System.out.println("BitManipulation Lock achieved");
            }
        }

    }

    public void method2() {

        synchronized (BitManipulation.class)
        {
            System.out.println("BitManipulation Synchronized Lock achieved");

            synchronized (FizzBuzz.class)
            {
                System.out.println("FizzBuzz Lock achieved");
            }
        }

    }

}

