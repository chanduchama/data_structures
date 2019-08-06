package com.implementation.interviews.yodlee.thirteen;

public class Main {
    public static void main(String[] args) {
        int start = Integer.MAX_VALUE - 10;
        int end = Integer.MAX_VALUE;
        int count = 0;
        System.out.println(start + " " + end);
        System.out.println(end-start);
        //This loop is never ending. Need to understand why this executed for ever and why the output is not 10
        for (int i = start; i <= end; i++) {
            count++;
        }
        System.out.println(count);
    }
}
