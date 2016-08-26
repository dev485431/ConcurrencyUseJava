package com.java.task2.atomic;

import com.java.task2.atomic.counters.Counter;

public class Task implements Runnable {

    public static final int INCREMENTS_COUNT = 1000;
    private Counter counter;

    public Task(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < INCREMENTS_COUNT; i++) {
            counter.increment();
        }
    }

}
