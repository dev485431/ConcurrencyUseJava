package com.java.task5.deadlock;

import java.util.concurrent.ConcurrentLinkedQueue;

import static com.java.task5.deadlock.Main.QUEUE_CAPACITY;

public class Producer implements Runnable {

    private ConcurrentLinkedQueue<String> queue;
    private final Object producerMonitor;
    private final Object consumerMonitor;
    private int counter = 0;

    public Producer(ConcurrentLinkedQueue<String> queue, Object producerMonitor, Object consumerMonitor) {
        this.queue = queue;
        this.producerMonitor = producerMonitor;
        this.consumerMonitor = consumerMonitor;
    }

    @Override
    public void run() {
        while (true) {
            String elem = "Product" + counter;
            if (queue.size() == QUEUE_CAPACITY) {
                synchronized (producerMonitor) {
                    try {
                        producerMonitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
            queue.add(elem);
            System.out.println(elem + " added to queue");

            if (queue.size() == 1) {
                synchronized (consumerMonitor) {
                    consumerMonitor.notifyAll();
                }
            }
            counter++;
        }
    }
}

