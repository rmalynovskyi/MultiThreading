package com.rmal.javaOOP.multithreading.lesson6.task4;

//4) Реализуйте многопоточное копирование каталога, содержащего несколько файлов.

import java.io.File;

public class Main {

    public static void main(String[] args) {
        MultiThreadCopyFile multiThreadCopyFile = new MultiThreadCopyFile();
        multiThreadCopyFile.multiCopyFile(new File("c:/Source"), "c:/Target");
    }
}
