package com.dataart.task5.blocking;

public class Producer2 implements Runnable {

    Producer2() {
    }

    @Override
    public void run() {
        System.out.println("ProducerNoBlocking1 Started 2");
    }

}
