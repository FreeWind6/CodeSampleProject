package com.javalesson.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//Thread pool
public class Other {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);// пул потоков (количество потоков)

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i)); //передали 5 заданий
        }

        executorService.shutdown(); //прекратили передачу заданий
        System.out.println("All task submitted");

        executorService.awaitTermination(1, TimeUnit.DAYS);//сколько ждать наши потоки до того как они выполнят задание
    }
}

class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work " + id + " was completed");
    }
}
