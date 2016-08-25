package com.dataart.task2.atomic;

import com.dataart.task2.atomic.counters.Counter;
import com.dataart.task2.atomic.counters.UnsafeCounter;
import com.dataart.utils.SysUtil;

public class Main {

    private static final int INCREMENT_COUNT = 9000;
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        testUnsafe();
        endTime = System.currentTimeMillis();
        System.out.println("testUnsafe = " + (endTime - startTime) + " milliseconds");
    }


    private static void testUnsafe() {
        Counter unsafeCounter = new UnsafeCounter();
        Thread thread[] = new Thread[INCREMENT_COUNT];

        for (int i = 0; i < INCREMENT_COUNT; i++) {
            thread[i] = new Thread(new Task(unsafeCounter), "Thread " + i);
        }

        for (int i = 0; i < INCREMENT_COUNT; i++) {
            thread[i].start();
        }

        SysUtil.sleep(5);
        System.out.println("Expected = " + INCREMENT_COUNT + " Actual UnsafeCounter = " + unsafeCounter.getValue());
    }

}
