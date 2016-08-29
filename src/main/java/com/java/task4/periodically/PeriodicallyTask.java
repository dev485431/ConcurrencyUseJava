package com.java.task4.periodically;

import java.util.Date;

public class PeriodicallyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Spaceship launched on " + new Date());
    }
}
