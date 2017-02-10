package com.rmal.javaOOP.multithreading.lesson6.task2;

/*2) Написать код для многопоточного подсчета суммы элементов
        массива целых чисел. Сравнить скорость подсчета с простым
        алгоритмом.*/

public class Main {

    public static void main(String[] args) {

        int[] array = OneThreadSum.createArray();
        OneThreadSum oneThreadSum = new OneThreadSum();
        MultiThreadSum multiThreadSum = new MultiThreadSum();

        //Standart algoritm
        long tstart = System.currentTimeMillis();
        int sum = oneThreadSum.sum(array, 0, array.length);
        long tend = System.currentTimeMillis();
        System.out.println("ms:" + (tend - tstart) + " sum of Array(one Thread): " + sum);

        //MultiThread algoritm
        long tstart1 = System.currentTimeMillis();
        int sum1 = multiThreadSum.sumArray(array);
        long tend1 = System.currentTimeMillis();
        System.out.println("ms1:" + (tend1 - tstart1) + " sum of Array(few threads): " + sum1);
    }
}
