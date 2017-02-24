package com.nc.rnd.prodconsumeblockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class ProdConsumeTest {

    public static void main (String args[])
    {
        BlockingQueue<Integer> list = new LinkedBlockingQueue<>();
        Thread prodThread = new Thread(new Producer(list, 10));
        Thread consThread = new Thread(new Consumer(list));

        prodThread.start();
        consThread.start();
    }
}
