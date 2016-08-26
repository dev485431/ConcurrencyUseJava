package com.java.task2.atomic.counters;

public class VolatileCounter extends Counter {

    private volatile int i = 0;

    @Override
    public void increment() {
        i = i + 1;
    }

    @Override
    public int getValue() {
        return i;
    }

}
