package com.javalesson.concurrency.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockLesson {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}

class Runner {
    private Account account1 = new Account();
    private Account account2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {//метод tryLock
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();//возвращает тру если доступна
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }

                if (firstLockTaken) {
                    lock1.unlock();
                }

                if (secondLockTaken) {
                    lock2.unlock();
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
/*            lock1.lock();
            lock2.lock();*/
            takeLocks(lock1, lock2);
            try {
                Account.tranfer(account1, account2, random.nextInt(100));//от 0 до 100
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
/*            lock1.lock();
            lock2.lock();*///всегда забирать локи в одном порядке
            takeLocks(lock2, lock1);
            try {
                Account.tranfer(account2, account1, random.nextInt(100));//от 0 до 100
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10000;

    public static void tranfer(Account acc1, Account acc2, int amount) {
        acc1.withDrow(amount);
        acc2.deposit(amount);
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withDrow(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
