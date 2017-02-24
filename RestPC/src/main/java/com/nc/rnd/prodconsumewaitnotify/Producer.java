package com.nc.rnd.prodconsumewaitnotify;

import java.util.List;
import java.util.Random;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class Producer implements Runnable{

    List<Integer> list;
    int size;

    public Producer(List<Integer> list, int size) {
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

    private void produce(int i)
    {
        while(list.size()  == size   )
        {
            synchronized (list) {
                try {
                    System.out.println("Queue is full - Waiting");
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Producing : " + i);

        synchronized (list)
        {
            list.add(i);
            list.notifyAll();
        }
    }
}
