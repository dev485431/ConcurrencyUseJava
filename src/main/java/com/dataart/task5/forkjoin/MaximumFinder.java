package com.dataart.task5.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MaximumFinder extends RecursiveTask<Integer> {

    private static final int PARALLELISM = 4;

    public static void main(String[] args) {
        int[] data = new int[1_000_000];
        initData(data);
        final ForkJoinPool pool = new ForkJoinPool(PARALLELISM);
    }

    @Override
    protected Integer compute() {
        return null;
    }

    private static void initData(int[] data) {
        final Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(888);
        }
    }
}