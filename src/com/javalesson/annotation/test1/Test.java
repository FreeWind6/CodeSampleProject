package com.javalesson.annotation.test1;

/*@MyAnnotation
public class Test {
    @MyAnnotation
    private String name;

    @MyAnnotation
    public Test() {

    }

    @MyAnnotation
    public void test(@MyAnnotation int value) {
        @MyAnnotation String localVar = "Hello";
    }

    @MyAnnotation
    public static void main(@MyAnnotation String[] args) {

    }
}*/

/*
public class Test {
    public static void main(String[] args) {
        MyThread myTread = new MyThread();
        myTread.start();
        System.out.println("Hello from main thread");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from MyThread");
    }
}*/

public class Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();//myMethod - устарел
    }
}
