package com.java.task3.cyclicbarrier;

public class Main {

    private static final int COUNT = 3;
    private static final int COUNT_THREADS = 50;

    public static void main(String args[]) {
        PrintQueue printQueue = new PrintQueue(COUNT);

        for (int i = 0; i < COUNT_THREADS; i++) {
            new Thread(new Printer(printQueue, "PrinterDevice" + (i + 1))).start();
        }
    }
}
