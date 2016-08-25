package com.java.task2.locks;

public class Main {

    private static final int SIZE = 5;

    public static void main(String args[]) {
        Thread thread[] = new Thread[SIZE];
        for (int i = 0; i < SIZE; i++) {
            thread[i] = new Thread(new Job(), "Printer " + i);
        }

        for (int i = 0; i < SIZE; i++) {
            thread[i].start();
        }
    }

}
