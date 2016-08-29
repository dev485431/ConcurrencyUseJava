package com.java.task3.cyclicbarrier;


import com.java.utils.SysUtil;

import java.util.concurrent.BrokenBarrierException;

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
            try {
                printQueue.recharge(name);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

