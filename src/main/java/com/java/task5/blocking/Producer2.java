package com.java.task5.blocking;

import com.java.utils.SysUtil;

import java.util.concurrent.BlockingQueue;

public class Producer2 implements Runnable {

    private BlockingQueue<String> queue;
    private int counter = 0;

    public Producer2(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("ProducerNoBlocking1 Started 2");
        while (true) {
            SysUtil.sleepRandom(1, 5);
            try {
                String elem = "Product " + counter;
                queue.put(elem);
                System.out.println("Producer 2: " + elem);
            } catch (InterruptedException e) {
                break;
            }
            counter++;
        }
    }

}
