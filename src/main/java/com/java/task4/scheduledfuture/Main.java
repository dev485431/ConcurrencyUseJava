package com.java.task4.scheduledfuture;

import com.java.utils.SysUtil;

public class Main {

    public static final int DELAY = 5;

    public static void main(String[] args) {
        System.out.println("Will start after " + DELAY + " seconds");

        SysUtil.sleep(15);
    }

}
