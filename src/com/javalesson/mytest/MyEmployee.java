package com.javalesson.mytest;

public class MyEmployee {
    private static int id = 1;
    private String name;
    private int age;
    private int elemid;

    public MyEmployee(int age, String name) {
        this.elemid = id++;
        this.age = age;
        this.name = name;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "MyEmployee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", elemid=" + elemid +
                '}';
    }
}
