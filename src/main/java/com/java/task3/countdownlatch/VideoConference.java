package com.java.task3.countdownlatch;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

    private static final Logger LOG = LogManager.getLogger(VideoConference.class);
    private int participantsNumber;
    private CountDownLatch countDownLatch;

    public VideoConference(int participantsNumber) {
        this.participantsNumber = participantsNumber;
        this.countDownLatch = new CountDownLatch(participantsNumber);
    }

    public void arrive(String name) {
        countDownLatch.countDown();
        LOG.info("{} has arrived.", name);
    }

    public void run() {
        try {
            LOG.info("Waiting for {} people to arrive at the conference.", participantsNumber);
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("All people have arrived. Starting conference.");
    }

}
