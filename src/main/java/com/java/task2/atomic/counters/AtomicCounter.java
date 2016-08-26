package com.java.task2.atomic.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter extends Counter {

    private AtomicInteger i = new AtomicInteger(0);

    @Override
    public void increment() {
        i.incrementAndGet();
    }

    @Override
    public int getValue() {
        return i.get();
    }

}
