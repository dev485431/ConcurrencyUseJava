package com.java.task5.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MaximumFinder extends RecursiveTask<Integer> {

    private static final int[] PARALLELISM = {4, 40, 80, 160};
    private static final int THRESHOLD = 10_000;
    private static final int DATA_SIZE = 100_000_000;
    private static final int RANDOM_MAX = 88_800_000;

    private int first;
    private int last;
    private int[] elements;

    public MaximumFinder(int first, int last, int[] elements) {
        this.first = first;
        this.last = last;
        this.elements = elements;
    }

    public static void main(String[] args) {
        findMax();
        for (int i = 0; i < PARALLELISM.length; i++) {
            int[] data = new int[DATA_SIZE];
            initData(data);
            findMaxParallel(PARALLELISM[i], data);
        }
    }

    @Override
    protected Integer compute() {
        if (last - first < THRESHOLD) {
            int result = elements[first];
            for (int i = first; i < last; i++) {
                result = Math.max(result, elements[i]);
            }
            return result;
        } else {
            int mid = (first + last) / 2;
            MaximumFinder leftFinder = new MaximumFinder(first, mid, elements);
            leftFinder.fork();
            MaximumFinder rightFinder = new MaximumFinder(mid, last, elements);
            int max2 = rightFinder.compute();
            int max1 = leftFinder.join();
            return Math.max(max1, max2);
        }
    }

    private static void initData(int[] data) {
        final Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(RANDOM_MAX);
        }
    }

    private static void findMax() {
        int[] data = new int[DATA_SIZE];
        initData(data);
        long start = System.currentTimeMillis();
        int result = data[0];
        for (int elem : data) {
            result = Math.max(result, elem);
        }
        System.out.println("Max number is " + result);
        System.out.println("Non-parallel search time =  " + (System.currentTimeMillis() - start) + " ms");
    }

    private static void findMaxParallel(int parallelism, int[] data) {
        final ForkJoinPool pool = new ForkJoinPool(parallelism);
        long start = System.currentTimeMillis();
        int result = pool.invoke(new MaximumFinder(0, data.length, data));
        System.out.println("Max number is " + result);
        System.out.println("Search time is for parallelism " + parallelism + " = " + (System.currentTimeMillis() -
                start) + " ms");
    }
}