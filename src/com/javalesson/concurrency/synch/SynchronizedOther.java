package com.javalesson.concurrency.synch;

public class SynchronizedOther {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedOther synchronizedOther = new SynchronizedOther();
        synchronizedOther.doWork();
    }

    public synchronized void increment(){ //синхронизировали потоки
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join(); //join заставляет подождать пока два потока
        thread2.join(); //завершат работу

        System.out.println(counter);
    }
}
