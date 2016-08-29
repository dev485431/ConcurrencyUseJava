package com.java.task4.periodically;

import com.java.utils.SysUtil;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int POOL_SIZE = 5;
    private static final int DELAY = 5;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        try {
            executor.scheduleAtFixedRate(new PeriodicallyTask(), 0, DELAY, TimeUnit.SECONDS);
            SysUtil.sleep(25);
        } finally {
            System.out.println("End of execution: " + new Date());
            executor.shutdown();
        }
    }


}
