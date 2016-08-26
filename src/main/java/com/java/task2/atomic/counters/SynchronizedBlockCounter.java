package com.java.task2.atomic.counters;

public class SynchronizedBlockCounter extends Counter {

    private int i = 0;

    @Override
    public void increment() {
        synchronized (this) {
            i = i + 1;
        }
    }

    @Override
    public int getValue() {
        synchronized (this) {
            return i;
        }
    }

}
