package com.java.task4.futuretask;

import com.java.utils.SysUtil;

import java.util.concurrent.Callable;

public class SpaceCraft implements Callable<String> {

    private String name;

    public SpaceCraft(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        long start = System.currentTimeMillis();
        SysUtil.sleepRandom(2, 5);
        return name + " has been prepared in " + (System.currentTimeMillis() - start + " milliseconds");
    }

}
