package com.java.task3.semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Job implements Runnable {

    private static final Logger LOG = LogManager.getLogger(Job.class);
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        LOG.info("Going to print: {}\n", Thread.currentThread().getName());
        printQueue.printJob();
    }

}
