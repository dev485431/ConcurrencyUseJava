package com.java.task5.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MaximumFinder extends RecursiveTask<Integer> {

    private static final int PARALLELISM = 4;
    private static final int THRESHOLD = 10000;

    private int firstIndex;
    private int lastIndex;
    private int[] elements;

    public MaximumFinder(int firstIndex, int lastIndex, int[] elements) {
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        this.elements = elements;
    }

    public static void main(String[] args) {
        int[] data = new int[1_000_000];
        initData(data);
        final ForkJoinPool pool = new ForkJoinPool(PARALLELISM);
        long start = System.currentTimeMillis();
        int result = pool.invoke(new MaximumFinder(0, data.length, data));
        System.out.println("Max number is " + result);
        System.out.println("Time is " + (System.currentTimeMillis() - start) + " ms");
    }

    @Override
    protected Integer compute() {
        if (lastIndex - firstIndex < THRESHOLD) {
            int result = elements[firstIndex];
            for (int i = firstIndex; i < lastIndex; i++) {
                result = Math.max(result, elements[i]);
            }
            return result;
        } else {
            int mid = (firstIndex + lastIndex) / 2;
            MaximumFinder leftFinder = new MaximumFinder(firstIndex, mid, elements);
            leftFinder.fork();
            MaximumFinder rightFinder = new MaximumFinder(mid, lastIndex, elements);
            int max2 = rightFinder.compute();
            int max1 = leftFinder.join();
            return Math.max(max1, max2);
        }
    }

    private static void initData(int[] data) {
        final Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(888);
        }
    }
}