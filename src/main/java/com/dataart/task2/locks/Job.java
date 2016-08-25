package com.dataart.task2.locks;

import com.dataart.utils.SysUtil;

public class Job implements Runnable {


    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        workProcess();
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }


    private void workProcess() {
        int duration = (int) (Math.random() * 10);
        System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + duration + " seconds");
        SysUtil.sleep(duration);
    }

}
