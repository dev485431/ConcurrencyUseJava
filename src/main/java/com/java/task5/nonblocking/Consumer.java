package com.java.task5.nonblocking;

import com.java.utils.SysUtil;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer implements Runnable {

    private ConcurrentLinkedQueue<String> queue;

    public Consumer(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Consumer Started");
        while (true) {
            String elem = queue.poll();
            if (elem != null) {
                SysUtil.sleepRandom(1, 4);
                System.out.println("Consumer: " + elem + " consumed");
            }
        }
    }

}
