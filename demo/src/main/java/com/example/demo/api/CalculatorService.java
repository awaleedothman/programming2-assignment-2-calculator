package com.example.demo.api;

import com.example.demo.model.Calculator;

import java.util.ArrayList;
import java.util.Collections;

public class CalculatorService {

    private static final Calculator calculator = new Calculator();

    public static Result getAnswer(String expression) {
        String[] arr = expression.split(",");
        ArrayList<String> expressionList = new ArrayList<>();
        Collections.addAll(expressionList, arr);
        try {
            finishPowers(expressionList);
            finishMultiplicationNDivision(expressionList);
            finishAdditionNSubtraction(expressionList);
            if (expressionList.size() != 1) throw new Exception();
            return new Result(String.valueOf(Float.parseFloat(expressionList.get(0))), false);
        } catch (Exception e) {
            return new Result("MATH ERROR", true);
        }
    }

    private static void finishPowers(ArrayList<String> expression) {
        for (int i = 0; i < expression.size(); ++i) {
            if (expression.get(i).equals("^")) {
                double result = calculator.pow(Double.parseDouble(expression.get(i-1)),
                        Double.parseDouble(expression.get(i+1)));
                expression.set(i-1, Double.toString(result));
                expression.remove(i);
                expression.remove(i);
                --i;
            }
        }
    }

    private static void finishMultiplicationNDivision(ArrayList<String> expression) throws Exception {
        for (int i = 0; i < expression.size(); ++i) {
            if (expression.get(i).equals("*")) {
                double result = calculator.multiply(Double.parseDouble(expression.get(i-1)),
                        Double.parseDouble(expression.get(i+1)));
                expression.set(i-1, Double.toString(result));
                expression.remove(i);
                expression.remove(i);
                --i;
            } else if (expression.get(i).equals("d")) {
                double result = calculator.divide(Double.parseDouble(expression.get(i-1)),
                        Double.parseDouble(expression.get(i+1)));
                expression.set(i-1, Double.toString(result));
                expression.remove(i);
                expression.remove(i);
                --i;
            }
        }
    }

    private static void finishAdditionNSubtraction(ArrayList<String> expression) {
        for (int i = 0; i < expression.size(); ++i) {
            if (expression.get(i).equals("+")) {
                double result = calculator.add(Double.parseDouble(expression.get(i-1)),
                        Double.parseDouble(expression.get(i+1)));
                expression.set(i-1, Double.toString(result));
                expression.remove(i);
                expression.remove(i);
                --i;
            } else if (expression.get(i).equals("-")) {
                double result = calculator.subtract(Double.parseDouble(expression.get(i-1)),
                        Double.parseDouble(expression.get(i+1)));
                expression.set(i-1, Double.toString(result));
                expression.remove(i);
                expression.remove(i);
                --i;
            }
        }
    }

}
