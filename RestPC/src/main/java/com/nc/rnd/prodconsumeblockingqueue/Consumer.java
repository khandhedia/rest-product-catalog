package com.nc.rnd.prodconsumeblockingqueue;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class Consumer implements Runnable {

    BlockingQueue<Integer> list;

    public Consumer(BlockingQueue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            consume(i);
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void consume(int i) {

        try {
            System.out.println("Consuming : " + list.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
