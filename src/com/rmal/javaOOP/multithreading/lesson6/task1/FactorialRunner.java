package com.rmal.javaOOP.multithreading.lesson6.task1;

/*1) Создайте сто потоков которые будут вычислять факториал
        числа равного номеру этого потока и выводить результат на
        экран.*/

public class FactorialRunner {

    public static void main(String[] args) {

        Thread[] array = new Thread[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Thread(new Factorial(i + 1));
            array[i].start();
        }
    }
}
