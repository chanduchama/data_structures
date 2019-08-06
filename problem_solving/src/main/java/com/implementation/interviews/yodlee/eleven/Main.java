package com.implementation.interviews.yodlee.eleven;

public class Main {
    public static void main(String[] args) {
        final String name = "Envestment Yodlee";
        Runnable r1 = () -> System.out.println(name);
        // Local variables referenced from a lambda expression must be final or effectively final
        String upperCaseName = "";
        //commenting this line as lambda expects a final member or effectively final
        //upperCaseName = name.toUpperCase();
        Runnable R2 = () -> System.out.println(upperCaseName);
        r1.run();
    }
}
