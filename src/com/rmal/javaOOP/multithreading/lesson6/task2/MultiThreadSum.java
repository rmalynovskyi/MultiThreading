package com.rmal.javaOOP.multithreading.lesson6.task2;

/*2) Написать код для многопоточного подсчета суммы элементов
        массива целых чисел. Сравнить скорость подсчета с простым
        алгоритмом.*/

class MultiThreadSum {
    private int[] array;
    private int begin;
    private int end;

    public MultiThreadSum(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
    }

    public MultiThreadSum() {
        super();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int sumArray(int[] array) {
        int sum = 0;
        Thread[] threads = new Thread[7];
        for (int i = 0; i < threads.length; i++) {
            int size = array.length / 7;
            int begin = size * i;
            int end = ((i + 1) * size);
            if ((array.length - end) < size) {
                end = array.length;
            }
            OneThreadSum one = new OneThreadSum(array, begin, end);
            threads[i] = new Thread(one);
            threads[i].start();
            sum += one.sum(array, begin, end);
        }
        return sum;
    }
}
