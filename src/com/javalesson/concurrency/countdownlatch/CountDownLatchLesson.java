package com.javalesson.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchLesson {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);//защелка обрадного отсчета при помощи countDown. Сколько мы раз вызывает countDownLatch.countDown - три раза

        ExecutorService executorService = Executors.newFixedThreadPool(3);//создаем 3 потока
        for (int i = 0; i < 3; i++)
            executorService.submit(new Processor(countDownLatch));//отправляем в наш executorService конструктор Processor с параметром countDownLatch

        executorService.shutdown();//обязательно вызывать на executorServiceв после команды submit

        countDownLatch.await();//ждем
        System.out.println("Latch has been opened, main thread is proceeding");//выводим после того как 3 раза пройдет поток

    }
}

class Processor implements Runnable {
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();//отсчитать назад -1
    }
}
