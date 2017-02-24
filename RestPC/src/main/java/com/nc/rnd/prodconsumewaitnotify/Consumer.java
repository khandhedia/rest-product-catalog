package com.nc.rnd.prodconsumewaitnotify;

import java.util.List;
import java.util.Random;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class Consumer implements Runnable{

    List<Integer> list;

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        for(int i = 0 ;i < 100 ; i++)
        {
            consume(i);
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void consume(int i)
    {
        while(list.isEmpty())
        {
            synchronized (list)
            {
                try {
                    list.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("Consuming : " + list.get(0));
        synchronized (list)
        {
            list.remove(0);
            list.notifyAll();
        }
    }
}
