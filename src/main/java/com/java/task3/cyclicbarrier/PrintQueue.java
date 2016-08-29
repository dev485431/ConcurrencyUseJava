package com.java.task3.cyclicbarrier;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class PrintQueue {

    private static final Logger LOG = LogManager.getLogger(PrintQueue.class);
    private Semaphore semaphore;
    private CyclicBarrier cyclicBarrier;
    private final Queue<String> queue = new LinkedList<>();

    public PrintQueue(int maxBuffer) {
        semaphore = new Semaphore(maxBuffer);
        cyclicBarrier = new CyclicBarrier(maxBuffer, new Runnable() {
            @Override
            public void run() {
                LOG.info("Queue is full");
                synchronized (queue) {
                    for (String name : queue) {
                        LOG.info("{} is printing", name);
                    }
                    queue.clear();
                }
            }
        });
    }

    public void recharge(String name) throws InterruptedException, BrokenBarrierException {
        semaphore.acquire();
        synchronized (queue) {
            queue.add(name);
        }
        cyclicBarrier.await();
        semaphore.release();
    }
}
