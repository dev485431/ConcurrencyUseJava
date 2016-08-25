package com.java.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SysUtil {

    private static final Random rand = new Random();

    public static void sleepRandom(int minSleep, int maxSleep) {
        try {
            TimeUnit.SECONDS.sleep(rand.nextInt(maxSleep) + minSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
