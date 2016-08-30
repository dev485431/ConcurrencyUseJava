package com.java.task5.blocking;

import com.java.utils.SysUtil;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Consumer Started");
        while (true) {
            try {
                String elem = queue.take();
                SysUtil.sleepRandom(1, 3);
                System.out.println("Consuming: " + elem);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
