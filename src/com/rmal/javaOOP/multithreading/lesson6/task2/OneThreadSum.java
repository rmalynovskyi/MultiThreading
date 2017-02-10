package com.rmal.javaOOP.multithreading.lesson6.task2;

/*2) Написать код для многопоточного подсчета суммы элементов
        массива целых чисел. Сравнить скорость подсчета с простым
        алгоритмом.*/

import java.util.Random;

class OneThreadSum implements Runnable {

    private int[] array;
    private int begin;
    private int end;

    public OneThreadSum(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
    }

    public OneThreadSum() {
        super();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public static int[] createArray() {
        int[] array = new int[7000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public int sum(int[] array, int begin, int end) {
        int sum = 0;
        for (int i = begin; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        System.out.println(th.getName() + " " + sum(array, begin, end));
    }
}
