package com.implementation.algorithms.threading.demo;

public class ThreadExecution {

    public static void main(String[] args) {
        ThreadImpl impl1 = new ThreadImpl();
        ThreadImpl impl2 = new ThreadImpl();

        impl1.start();
        impl2.start();
    }

}
