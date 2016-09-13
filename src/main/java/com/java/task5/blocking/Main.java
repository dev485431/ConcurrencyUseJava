package com.java.task5.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private static final int CAPACITY = 50;

    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(CAPACITY);
        Thread producer1 = new Thread(new Producer1(queue));
        Thread producer2 = new Thread(new Producer2(queue));

        Thread consumer = new Thread(new Consumer(queue));
        producer1.start();
        producer2.start();
        consumer.start();
    }
}
