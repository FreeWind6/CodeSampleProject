package com.javalesson.concurrency.volatilelesson;

import java.util.Scanner;

public class VolatileOther {
    public static void main(String[] args) {
        /*volatile - настраивает взаимодействие потоков
         *используется если одна переменная в нескольких потоках
         * */

        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();//останавливает после enter
    }
}

class MyThread extends Thread {

    private static volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
