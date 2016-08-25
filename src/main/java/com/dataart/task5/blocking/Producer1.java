package com.dataart.task5.blocking;

public class Producer1 implements Runnable {

    Producer1() {
    }

    @Override
    public void run() {
        System.out.println("ProducerNoBlocking1 Started 1");
    }
}
