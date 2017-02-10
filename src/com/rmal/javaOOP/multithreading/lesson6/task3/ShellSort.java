package com.rmal.javaOOP.multithreading.lesson6.task3;

//3) Напишите многопоточный вариант сортировки массива методом Шелла.

import java.util.Arrays;
import java.util.Random;

class ShellSort implements Runnable {

    private int[] array;
    private int begin;
    private int end;
    private Thread thr;
    private int index;
    private boolean stop = false;

    public ShellSort(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);
        thr.start();
        this.index = begin;
    }

    public ShellSort() {
        super();
    }

    public Thread getThr() {
        return thr;
    }

    public int peekElement() {
        return array[index];
    }

    public int pollElement() {
        int temp = array[index];
        check();
        return temp;
    }

    public boolean isStop() {
        return stop;
    }

    private void check() {
        this.index++;
        if (this.index >= this.end) {
            this.stop = true;
        }
    }

    public static int[] createArray() {
        int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public int[] sortArray(int[] array, int begin, int end) {
        int d = end / 2;
        while (d > 0) {
            for (int i = begin; i < end - d; i++) {
                int j = i;
                while (j >= begin && array[j] > array[j + d]) {
                    int temp = array[j];
                    array[j] = array[j + d];
                    array[j + d] = temp;
                    j--;
                }
            }
            d /= 2;
        }
        return array;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        System.out.println(th.getName() + ":" + Arrays.toString(sortArray(array, begin, end)));
    }
}
