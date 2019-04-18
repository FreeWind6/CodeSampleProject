package com.javalesson.concurrency.callcbleandfuture;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureOther {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //в Callable мы можем вернуть значение в отличаи от Runnable
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                Random random = new Random();
                int randomValue = random.nextInt();
                if (randomValue < 5) {
                    throw new Exception("Something bad happened");
                }
                return random.nextInt(10);
            }
        });

/*        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        });*/

        executorService.shutdown();//запустили

        try {
            int result = future.get();//get дожидается окончания выполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause(); //получаем причину исключения
            System.out.println(ex.getMessage());//выводим на экран throw new Exception("Something bad happened");
        }
    }
}
