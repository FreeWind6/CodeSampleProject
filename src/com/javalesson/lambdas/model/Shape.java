package com.javalesson.lambdas.model;

import java.util.List;

public interface Shape {

    static double calcShapesSquare(List<Shape> shapes){
        double squareSum = 0;
        for(Shape shape:shapes){
            squareSum = squareSum + shape.calcSquare();
        }
        return squareSum;
    }

    double calcSquare();

    default double calcSomething(){
        return 1;
    }
}
