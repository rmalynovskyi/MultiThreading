package com.rmal.javaOOP.multithreading.lesson6.task3;

//3) Напишите многопоточный вариант сортировки массива методом Шелла.

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Create source array
        int[] array = ShellSort.createArray();

        // Print out source array
        System.out.println("Source array: " + Arrays.toString(array));

        // Multithreading sort
        MultiThreadShellSort multiThreadShellSort = new MultiThreadShellSort();
        multiThreadShellSort.sort(array,10);

        // Print out sorted array
        System.out.println("Sorted array :" + Arrays.toString(array));
    }
}
