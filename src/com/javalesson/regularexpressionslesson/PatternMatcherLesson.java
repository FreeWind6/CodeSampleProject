package com.javalesson.regularexpressionslesson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherLesson {
    public static void main(String[] args) {
        String text = "Hello my friends! I am bla nice joe@gmail.com\n" +
                "keep int touch. Thanks Joe! That`s alala\n" +
                "my address: tim@yandex.ru. Lets stay int touch...";

        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");//то что ищем
        Matcher matcher = email.matcher(text);//ищем по тексту

        while (matcher.find()) {
            /* group() возвращает то что бы ло найдено методом find (если ничего не задавать то вернет весь патерн)
             * если вписать чтото типа group(1) то тут id = 1
             * а из нашего выражения видно что ("(\\w+)@(gmail|yandex)\\.(com|ru)")
             * (\\w+) = 1
             * (gmail|yandex) = 2
             * (com|ru) = 3
             * все разделено скобками!
             */
            System.out.println(matcher.group());
            System.out.println("ID 1 = " + matcher.group(1));
            System.out.println("ID 2 = " + matcher.group(2));
            System.out.println("ID 3 = " + matcher.group(3));
        }
    }
}
