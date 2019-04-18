package com.javalesson.regularexpressionslesson;

public class RegularExpressionsLesson1 {
    public static void main(String[] args) {
        /*
         * Регулярные выражения
         * \\d - одна цифра
         * \\w - буква или цифра или знак подчеркивания
         * \\w = [a-zA-Z_0-9]
         *
         * + - один или более
         * * - ноль или более
         * пример: -\\d* - минус ноль или более цифр
         * ? - ноль или 1 символов до
         * пример: -?\\d+ - и положительные и отрицательные
         *
         * ( | ) - одна строка из множества строк (или)
         *
         * [abc] = (a|b|c)
         * [a-zA-z] - все английские буквы
         * [0-9] = \\d
         * [^123] - все цифры кроме 1 2 3
         *
         * . - любой символ
         *
         * {2} - два символа до (\\d{2})
         * {2, } - два или более символа (\\d{2,})
         * {2, 4} - от двух до четырех символов (\\d{2,4})
         */

        String a = "554564654564";
        String b = "-554564654564";
        String c = "+554564654564";

        System.out.println(a.matches("\\d*"));//сравниваем
        System.out.println(b.matches("-?\\d*"));//сравниваем
        System.out.println(c.matches("(-|\\+)?\\d*"));//либо минус либо плюс

        String d = "d3as5A3SDd5sa1567489";
        System.out.println(d.matches("[a-zA-z53]+\\d+"));

        String e = "heallo";
        System.out.println(e.matches("[^abc]*"));

        String url = "http://www.google.com";
        String url2 = "http://www.yandex.ru";
        String url3 = "http://www.big.en";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url3.matches("http://www\\..+\\.(com|ru)"));

        String f = "12";
        System.out.println(f.matches("\\d{2,}"));
    }
}
