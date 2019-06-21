package com.javalesson.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        Class personClass1 = person.getClass();

/*        Class personClass2 = Person.class;

        Class personClass3 = Class.forName("Person");*/

        //personClass3 и personClass2 и personClass1 одно и тоже, просто по разному получаются

        Method[] methods = personClass1.getMethods();//getMethods - возвращает все поля, даже приватные
        for (Method method : methods) {
            System.out.println(method.getName() + ", "
                    + method.getReturnType() + ", "
                    + Arrays.toString(method.getParameterTypes()));//то что принимает в скобках
        }

        System.out.println("---------------------------");

//getFields - возвращает только публичные поля
//getDeclaredFields - возвращает все поля, даже приватные
        Field[] fields = personClass1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ", "
                    + field.getType());
        }

        System.out.println("---------------------------");

//Проверяем содержит ли personClass1 анотацию Author и если да то выводим это
        Annotation[] annotations = personClass1.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println("Yes!");
            }
        }
    }
}
