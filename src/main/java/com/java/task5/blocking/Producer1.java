package com.java.task5.blocking;

import com.java.utils.SysUtil;

import java.util.concurrent.BlockingQueue;

public class Producer1 implements Runnable {

    private BlockingQueue<String> queue;
    private int counter = 0;

    public Producer1(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("ProducerNoBlocking1 Started 1");
        while (true) {
            SysUtil.sleepRandom(1, 5);
            try {
                String elem = "Construction " + counter;
                queue.put(elem);
                System.out.println("Producer 1: " + elem);
            } catch (InterruptedException e) {
                break;
            }
            counter++;
        }
    }
}