package com.java.task4.futuretask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTaskLauncher {

    private static final Logger LOG = LogManager.getLogger(FutureTaskLauncher.class);
    private static final int POOL_SIZE = 5;
    private static final int SPACECRAFT_SIZE = 20;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        Future[] futures = new Future[SPACECRAFT_SIZE];

        try {
            for (int i = 0; i < SPACECRAFT_SIZE; i++) {
                futures[i] = executor.submit(new SpaceCraft("Spacecraft " + i));
            }

            for (int i = 0; i < SPACECRAFT_SIZE; i++) {
                LOG.info(futures[i].get());
            }
            LOG.info("All spacecrafts prepared and launched!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

}
