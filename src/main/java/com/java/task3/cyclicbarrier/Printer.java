package com.java.task3.cyclicbarrier;


import com.java.utils.SysUtil;

public class Printer implements Runnable {

    private String name;
    private PrintQueue printQueue;

    public Printer(PrintQueue printQueue, String name) {
        this.name = name;
        this.printQueue = printQueue;
    }

    public void run() {
        while (true) {
            SysUtil.sleepRandom(2, 9);
            printQueue.recharge(name);
        }
    }
}

