package com.rmal.javaOOP.multithreading.lesson6.task5;

/*5) Реализуйте программу которая с периодичностью 1 сек,
        будет проверять состояние заданного каталога. Если в этом
        каталоге появиться новый файл или исчезнет, то выведет
        сообщение об этом событии. Программа должна работать в
        параллельном потоке выполнения.*/

import java.io.File;

public class FileCheckerRunner {

    public static void main(String[] args) {
        FileChecker fileChecker = new FileChecker(new File("c:/Source"));
        Thread thread = new Thread(fileChecker);
        thread.start();
    }
}
