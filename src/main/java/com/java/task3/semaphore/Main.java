package com.java.task3.semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);
    private static final int COUNT = 50;
    private static final int AT_THE_SAME_TIME_COUNT = 5;

    public static void main(String args[]) {

        PrintQueue printQueue = new PrintQueue(AT_THE_SAME_TIME_COUNT);

        Thread thread[] = new Thread[COUNT];
        for (int i = 0; i < COUNT; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (int i = 0; i < COUNT; i++) {
            thread[i].start();
        }

        for (int i = 0; i < COUNT; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        LOG.info("Printing finished");
    }
}
