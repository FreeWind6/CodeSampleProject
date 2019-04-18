package com.javalesson.concurrency.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class Other {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

/*
 *если синхронизируемся не на this то должны это явно указать например синхрон. на обьектие lock, тогда lock.wait и lock.notify
 *notify и wait - должны синхронизироваться на одном обьекте тут - this
 *notifyAll() - что все потоки что ждут - проснулись
 *notify() - что 1 поток что ждет - проснулся
 */

class ProducerConsumer {
    private final int LIMIT = 10;
    private final Object lock = new Object();
    private Queue<Integer> queue = new LinkedList();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    lock.wait();
                }
                queue.offer(value++);//добавляем элемент
                lock.notify();
            }
        }

/*        synchronized (this) {
            System.out.println("Producer thread started...");
            wait(); // 1 - одаем intrinsic lock, 2 - ждем пока будет вызван notify
            System.out.println("Producer thread resumed...");
        }*/
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                Integer value = queue.poll();//достает элемент из очереди
                System.out.println(value);
                System.out.println("Queue size is " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
/*        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            notify();
            Thread.sleep(5000);//через 5 секунд отдаст монитор
        }*/
    }
}
