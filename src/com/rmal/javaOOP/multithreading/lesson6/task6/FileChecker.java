package com.rmal.javaOOP.multithreading.lesson6.task6;

/*5)    Реализуйте программу которая с периодичностью 1 сек,
        будет проверять состояние заданного каталога. Если в этом
        каталоге появиться новый файл или исчезнет, то выведет
        сообщение об этом событии. Программа должна работать в
        параллельном потоке выполнения.*/

import java.io.File;
import java.util.Arrays;
import java.util.List;

class FileChecker implements Runnable {
    private File file;

    public FileChecker(File file) {
        this.file = file;
    }

    public FileChecker() {
        super();
    }

    @Override
    public void run() {
        while (true) {
            String[] array1 = this.file.list();
            List<String> one = Arrays.asList(array1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkFolder(one);
        }
    }

    private void checkFolder(List<String> one) {
        String[] array2 = this.file.list();
        List<String> two = Arrays.asList(array2);
        if (one.size() > two.size()) {
            for (String elem : one) {
                if (!two.contains(elem)) {
                    System.out.println("File " + elem + " deleted!");
                }
            }
        } else if (one.size() < two.size()) {
            for (String elem : two) {
                if (!one.contains(elem)) {
                    System.out.println("File " + elem + " created!");
                }
            }
        } else {
            System.out.println("Folder not changed!");
        }
    }
}
