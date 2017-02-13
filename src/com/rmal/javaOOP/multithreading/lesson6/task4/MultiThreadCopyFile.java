package com.rmal.javaOOP.multithreading.lesson6.task4;

//4) Реализуйте многопоточное копирование каталога, содержащего несколько файлов.

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        ExecutorService exSer = Executors.newFixedThreadPool(5);
        ArrayList<Future<Integer>> result = new ArrayList<>();
        for (File elem : files) {
            result.add(exSer.submit(new CopyFile(elem, copypath + "/" + copyFolder.getName() + "/" + elem.getName())));
        }
        int totalCount = 0;
        for (Future<Integer> future : result) {
            try {
                totalCount += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Number of copied files: " + totalCount);
        exSer.shutdown();
    }
}
