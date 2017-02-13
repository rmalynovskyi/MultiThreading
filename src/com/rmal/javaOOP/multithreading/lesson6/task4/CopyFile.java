package com.rmal.javaOOP.multithreading.lesson6.task4;

//4) Реализуйте многопоточное копирование каталога, содержащего несколько файлов.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

class CopyFile implements Callable<Integer> {
    private File source;
    private String pathOfCopy;

    public CopyFile(File source, String pathOfCopy) {
        this.source = source;
        this.pathOfCopy = pathOfCopy;
    }

    public CopyFile() {
        super();
    }

    public File getSource() {
        return source;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        Thread th = Thread.currentThread();
        System.out.println(th.getName() + " copying file: " + source.getName());
        try (FileInputStream input = new FileInputStream(source);
             FileOutputStream output = new FileOutputStream(pathOfCopy)) {
            byte[] buffer = new byte[1024];
            int byteread;
            for (; (byteread = input.read(buffer)) > 0; ) {
                output.write(buffer, 0, byteread);
            }
            count++;
        } catch (IOException e) {
            System.out.println(e);
        }
        return count;
    }
}
