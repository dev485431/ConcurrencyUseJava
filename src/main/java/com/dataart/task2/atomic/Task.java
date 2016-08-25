package com.dataart.task2.atomic;

import com.dataart.task2.atomic.counters.Counter;

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
