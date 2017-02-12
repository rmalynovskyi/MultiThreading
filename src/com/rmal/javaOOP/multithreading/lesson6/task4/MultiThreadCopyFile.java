package com.rmal.javaOOP.multithreading.lesson6.task4;

//4) Реализуйте многопоточное копирование каталога, содержащего несколько файлов.

import java.io.File;

public class MultiThreadCopyFile {
    private File[] files;

    public MultiThreadCopyFile() {
        super();
    }

    public void multiCopyFile(File source, String copypath) {
        if (!source.exists()) {
            System.out.println("Source file not exist!!!");
            return;
        }
        CopyFile copyFile = new CopyFile(source, copypath);
        File copyFolder = new File(copypath + "/" + source.getName());
        copyFolder.mkdir();
        files = copyFile.getSource().listFiles();
        Thread[] threads = new Thread[files.length];
        int i = 0;
        for (File elem : files) {
            CopyFile c = new CopyFile(elem, copypath + "/" + copyFolder.getName() + "/" + elem.getName());
            threads[i] = new Thread(c);
            threads[i].start();
            i++;
        }
    }
}
