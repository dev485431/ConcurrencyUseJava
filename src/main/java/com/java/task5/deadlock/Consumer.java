package com.java.task5.deadlock;

import java.util.concurrent.ConcurrentLinkedQueue;

import static com.java.task5.deadlock.Main.QUEUE_CAPACITY;

public class Consumer implements Runnable {

    private ConcurrentLinkedQueue<String> queue;
    private final Object producerMonitor;
    private final Object consumerMonitor;

    public Consumer(ConcurrentLinkedQueue<String> queue, Object producerMonitor, Object consumerMonitor) {
        this.queue = queue;
        this.consumerMonitor = consumerMonitor;
        this.producerMonitor = producerMonitor;
    }

    @Override
    public void run() {
        while (true) {
            if (queue.isEmpty()) {
                synchronized (consumerMonitor) {
                    try {
                        consumerMonitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
            String elem = queue.poll();
            System.out.println(elem + " removed from queue");

            if (queue.size() == QUEUE_CAPACITY - 1) {
                synchronized (producerMonitor) {
                    producerMonitor.notifyAll();
                }
            }
        }
    }
}
