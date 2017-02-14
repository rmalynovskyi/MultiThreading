package com.rmal.javaOOP.multithreading.lesson6.task5;

/*5) Реализуйте программу которая с периодичностью 1 сек,
        будет проверять состояние заданного каталога. Если в этом
        каталоге появиться новый файл или исчезнет, то выведет
        сообщение об этом событии. Программа должна работать в
        параллельном потоке выполнения.*/

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

class FileChecker implements Runnable {
    private File file;

    public FileChecker(File file) {
        this.file = file;
    }

    public FileChecker() {
        super();
    }

    public void checkFolder() {
        Path path = this.file.toPath();
        WatchService watchService = null;
        try {
            watchService = path.getFileSystem().newWatchService();
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            WatchKey watchKey = getWatchKey(watchService);
            watchKey.reset();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private WatchKey getWatchKey(WatchService watchService) {
        WatchKey watchKey = null;
        try {
            watchKey = watchService.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WatchEvent event : watchKey.pollEvents()) {
            if (event.kind().name() == "ENTRY_CREATE") {
                System.out.println("File " + event.context() + " has been created in catalog " + this.file.getName());
            }
            if (event.kind().name() == "ENTRY_DELETE") {
                System.out.println("File " + event.context() + " has been deleted from catalog " +  this.file.getName());
            }
        }
        return watchKey;
    }

    public void run() {
        checkFolder();
    }
}
