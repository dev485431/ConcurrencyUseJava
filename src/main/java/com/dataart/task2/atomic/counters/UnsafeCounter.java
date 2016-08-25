package com.dataart.task2.atomic.counters;

public class UnsafeCounter extends Counter {

    private int i = 0;

    @Override
    public void increment() {
        i = i + 1;
    }

    @Override
    public int getValue() {
        return i;
    }
}
