package com.java.task2.atomic;

import com.java.task2.atomic.counters.Counter;

public class Task implements Runnable {

    private Counter atomicCounter;

    public Task(Counter atomicCounter) {
        this.atomicCounter = atomicCounter;
    }

    @Override
    public void run() {
        atomicCounter.increment();
    }

}
