package com.java.task3.countdownlatch;

import com.java.utils.SysUtil;

public class Participant implements Runnable {

    private VideoConference videoConference;
    private String name;

    public Participant(VideoConference conference, String name) {
        this.videoConference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        SysUtil.sleepRandom(2, 9);
        videoConference.arrive(name);
    }

}
