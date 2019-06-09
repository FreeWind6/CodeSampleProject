package com.javalesson.annotation.test2;

public class Test {

    @MethodInfo(author = "Ya", purpose = "Print Hello World")
    public void printHelloWorld() {
        System.out.println("Hello world");
    }
}
