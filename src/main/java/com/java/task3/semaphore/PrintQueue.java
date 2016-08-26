package com.java.task3.semaphore;

import com.java.utils.SysUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public class PrintQueue {

    private static final Logger LOG = LogManager.getLogger(PrintQueue.class);
    private final int maxPrintsCount;
    private Semaphore semaphore;

    public PrintQueue(int maxPrintsCount) {
        this.maxPrintsCount = maxPrintsCount;
        this.semaphore = new Semaphore(maxPrintsCount);
    }

    public void printJob() {
        try {
            semaphore.acquire();
            LOG.info("Printing: " + Thread.currentThread().getName());
            LOG.info("Number of running jobs: {}\n", maxPrintsCount - semaphore.availablePermits());
            SysUtil.sleepRandom(2, 5);
            LOG.info("Finished printing: {}\n", Thread.currentThread().getName());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
