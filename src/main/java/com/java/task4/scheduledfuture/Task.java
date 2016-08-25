package com.java.task4.scheduledfuture;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    public String call() throws Exception {
        System.out.println("Spaceship has launched " + new Date());
        return new Date().toString();
    }

}
