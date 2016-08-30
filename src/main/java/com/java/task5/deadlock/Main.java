package com.java.task5.deadlock;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static final int QUEUE_CAPACITY = 50;

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        Object producerMonitor = new Object();
        Object consumerMonitor = new Object();
        Thread producer = new Thread(new Producer(queue, producerMonitor, consumerMonitor));
        Thread consumer = new Thread(new Consumer(queue, producerMonitor, consumerMonitor));
        producer.start();
        consumer.start();
    }

}
