package com.nc.rnd.prodconsumeblockingqueue;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class Producer implements Runnable{

    BlockingQueue<Integer> list;
    int size;

    public Producer(BlockingQueue<Integer> list, int size) {
        this.list = list;
        this.size = size;
    }

    @Override
    public void run() {

        for (int i = 0 ; i < 100 ; i++)
        {
            produce(i);
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void produce(int i) {
        System.out.println("Producing : " + i);

        try {
            list.put(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
