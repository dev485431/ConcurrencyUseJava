package com.java.task1;

import com.java.task1.threads.ElementBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadFactory;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        };

        Thread foundationThread = factory.newThread(new ElementBuilder("Thread 1 foundation", null));
        Thread wallThread = factory.newThread(new ElementBuilder("Thread 2 walls", foundationThread));
        Thread roofThread = factory.newThread(new ElementBuilder("Thread 3 roof", wallThread));

        LOG.info("Starting building the house");
        foundationThread.start();
        wallThread.start();
        roofThread.start();
        try {
            roofThread.join();
            LOG.info("The house has been built");
        } catch (InterruptedException e) {
            LOG.error("Building was interrupted: {}", e.getMessage());
        }

    }
}

