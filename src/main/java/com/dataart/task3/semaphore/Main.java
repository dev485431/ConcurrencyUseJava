package com.dataart.task3.semaphore;

public class Main {

    private static final int COUNT = 50;
    private static final int AT_THE_SAME_TIME_COUNT = 5;

    public static void main(String args[]) {

        PrintQueue printQueue = new PrintQueue(AT_THE_SAME_TIME_COUNT);

        Thread thread[] = new Thread[COUNT];
        for (int i = 0; i < COUNT; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (int i = 0; i < COUNT; i++) {
            thread[i].start();
        }

    }
}
