package com.java.task2.atomic.counters;

public class SynchronizedMethodCounter extends Counter {

    private int i = 0;

    @Override
    public synchronized void increment() {
        i = i + 1;
    }

    @Override
    public synchronized int getValue() {
        return i;
    }
}
