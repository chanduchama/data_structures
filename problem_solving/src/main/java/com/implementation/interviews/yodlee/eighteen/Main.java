package com.implementation.interviews.yodlee.eighteen;

public class Main {
    public static void main(String[] args) {
        try{
            method();
            System.out.println("Hello World");
        }catch (Error e) {
            System.out.println("Caught Error");
        }
    }
    private static int method() {
        return method();
    }
}
