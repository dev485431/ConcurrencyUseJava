package com.dataart.task3.semaphore;

import com.dataart.utils.SysUtil;

public class Job implements Runnable {

    private PrintQueue printQueue;


    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        SysUtil.sleepRandom(2,5);
        System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
        printQueue.printJob();
    }



}
