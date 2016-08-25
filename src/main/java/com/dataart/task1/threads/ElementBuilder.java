package com.dataart.task1.threads;

import com.dataart.task1.utils.SleepTimeGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElementBuilder implements Runnable {

    private static final Logger LOG = LogManager.getLogger(ElementBuilder.class);

    protected String threadName;
    protected Thread prevThread;

    public ElementBuilder(String threadName, Thread prevThread) {
        this.threadName = threadName;
        this.prevThread = prevThread;
    }

    @Override
    public void run() {
        LOG.info("Started: {}", threadName);
        try {
            SleepTimeGenerator.sleepRandom(1, 10);
            if (prevThread != null) {
                prevThread.join();
            }
            LOG.info("{} has finished building", threadName);
        } catch (InterruptedException e) {
            LOG.error("Building interrupted: {}", e.getMessage());
        }
    }
}
