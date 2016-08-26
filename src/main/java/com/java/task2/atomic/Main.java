package com.java.task2.atomic;

import com.java.task2.atomic.counters.*;

import static com.java.task2.atomic.Task.INCREMENTS_COUNT;

public class Main {

    private static final int INCREMENTORS_COUNT = 9000;

    public static void main(String[] args) {
        testCounter(new UnsafeCounter(), "Unsafe Counter");
        testCounter(new VolatileCounter(), "Volatile Counter");
        testCounter(new AtomicCounter(), "Atomic Counter");
        testCounter(new SynchronizedBlockCounter(), "Synchronized Block Counter");
        testCounter(new SynchronizedMethodCounter(), "Synchronized Method Counter");
    }

    private static void testCounter(Counter counter, String counterName) {
        Thread thread[] = new Thread[INCREMENTORS_COUNT];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < INCREMENTORS_COUNT; i++) {
            thread[i] = new Thread(new Task(counter), "Thread " + i);
        }

        for (int i = 0; i < INCREMENTORS_COUNT; i++) {
            thread[i].start();
        }

        for (int i = 0; i < INCREMENTORS_COUNT; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Counter: " + counterName);
        System.out.println("Expected = " + INCREMENTORS_COUNT * INCREMENTS_COUNT + " Actual = " + counter.getValue());
        System.out.println("TestTime = " + (endTime - startTime) + " milliseconds\n");
    }

}
