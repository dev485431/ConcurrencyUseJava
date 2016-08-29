package com.java.task4.scheduledfuture;

import com.java.utils.SysUtil;

import java.util.Date;
import java.util.concurrent.*;

public class Main {

    public static final int DELAY = 5;
    public static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        System.out.println("Current time is " + new Date() + ". A spaceship will start in " + DELAY + " seconds");
        try {
            ScheduledFuture<String> future = executor.schedule(new Task(), DELAY, TimeUnit.SECONDS);
            System.out.println("The completion date returned by the task: " + future.get());
            SysUtil.sleep(15);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            System.out.println("Executor shutdown on: " + new Date());
        }
    }

}
