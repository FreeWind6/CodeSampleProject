package com.javalesson.lambdas;

public class TransformUtils<T> {

    static String exclaim(String s){
        return s.toUpperCase()+"!!!!";
    }

    T transform(T t, Transformable<T> function){
        return function.transform(t);
    }
}
