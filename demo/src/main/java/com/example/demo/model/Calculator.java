package com.example.demo.model;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws Exception {
        if (b == 0) throw new Exception();
        return a / b;
    }

    public double pow(double a, double b) {
        return Math.pow(a, b);
    }

}
