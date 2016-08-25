package com.java.task5.blocking;

public class Main {

    public static void main(String[] args) throws Exception {

        Thread producer1 = new Thread(new Producer1());
        Thread producer2 = new Thread(new Producer2());

        Thread consumer = new Thread(new Consumer());
        producer1.start();
        producer2.start();
        consumer.start();
    }
}
