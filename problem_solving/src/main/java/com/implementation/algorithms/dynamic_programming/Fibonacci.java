package com.implementation.algorithms.dynamic_programming;

public class Fibonacci {

    public static void main(String[] args) {

        int n1 = 1;
        int n2 = 1;
        int n3;
        int count = 10;

        System.out.print(n1 + " " + n2 + " ");

        for (int i = 2; i <= count ; i++) {

            n3 = n1 + n2;

            System.out.print(n3);
            System.out.print(" ");

            n1 = n2;
            n2 = n3;

        }

    }

}
