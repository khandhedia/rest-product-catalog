package com.nc.rnd.prodconsumewaitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class ProdConsumeTest {

    public static void main (String args[])
    {
        List<Integer> list = new ArrayList<>();
        Thread prodThread = new Thread(new Producer(list, 10));
        Thread consThread = new Thread(new Consumer(list));

        prodThread.start();
        consThread.start();
    }
}
