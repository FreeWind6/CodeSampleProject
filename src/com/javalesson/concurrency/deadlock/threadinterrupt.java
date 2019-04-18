package com.javalesson.concurrency.deadlock;

import java.util.Random;

public class threadinterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1000000000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread was interrupted");
                        break;//если isInterrupted тру то выходим из цикла
                    }

                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Starting thread");

        thread.start();

        Thread.sleep(1000);
        thread.interrupt();//прервали поток

        thread.join();

        System.out.println("Thread finished");
    }
}
