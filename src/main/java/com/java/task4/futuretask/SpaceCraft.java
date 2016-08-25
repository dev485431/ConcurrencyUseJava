package com.java.task4.futuretask;

import com.java.utils.SysUtil;

import java.util.concurrent.Callable;

public class SpaceCraft implements Callable<String> {

    @Override
    public String call() {
        SysUtil.sleepRandom(2, 5);
        return Thread.currentThread().getName() + " has prepared";
    }

}
