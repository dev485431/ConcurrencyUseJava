package com.java.task3.countdownlatch;

public class Main {

    private static final int COUNT = 5;

    public static void main(String[] args) {
        VideoConference conference = new VideoConference(COUNT);
        Thread thread = new Thread(conference);
        thread.start();

        for (int i = 0; i < COUNT; i++) {
            Participant p = new Participant(conference, " Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }

}
