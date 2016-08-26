package com.java.task2.locks;

import com.java.utils.SysUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Job implements Runnable {

    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        workProcess();
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
        lock.unlock();
    }


    private void workProcess() {
        int duration = (int) (Math.random() * 10);
        System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + duration + " " +
                "seconds");
        SysUtil.sleep(duration);
    }

}
