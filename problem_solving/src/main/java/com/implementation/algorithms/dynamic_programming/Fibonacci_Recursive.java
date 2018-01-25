package com.implementation.algorithms.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci_Recursive {

    public static void main(String[] args) {
        Fibonacci_Recursive  fibonacci = new Fibonacci_Recursive();

        fibonacci.printFibonacciNumbers(10);
    }

    // using memorization technique to remember the value computed for a fibonacci number
    Map<Integer, Integer> fibonacciMap = new HashMap<Integer, Integer>();

    public void printFibonacciNumbers(int fibonacciCount) {

        for (int i = 0; i < fibonacciCount; i++) {

            int fibonacci = getFibonacci(i);

            System.out.print(fibonacci + " ");
        }

    }

    private int getFibonacci(int index) {
        int fibonacciNumber = -1;

        if( index == 0 || index == 1 ) {
            fibonacciNumber = 1;
        } else if( fibonacciMap.containsKey(index) ) {
            fibonacciNumber = fibonacciMap.get(index);
        } else {
            fibonacciNumber = getFibonacci(index-1) + getFibonacci(index-2);
            fibonacciMap.put(index, fibonacciNumber);
        }

        return fibonacciNumber;
    }

}
