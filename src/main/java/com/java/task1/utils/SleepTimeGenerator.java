package com.java.task1.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SleepTimeGenerator {

    private static final Logger LOG = LogManager.getLogger(SleepTimeGenerator.class);
    private static final Random rand = new Random();

    public static void sleepRandom(int min, int max) {
        try {
            TimeUnit.SECONDS.sleep(rand.nextInt(max - min + 1) + min);
        } catch (InterruptedException e) {
            LOG.info("Sleeping interrupted: {}", e.getMessage());
        }
    }

    public static void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            LOG.info("Sleeping interrupted: {}", e.getMessage());
        }
    }

}
