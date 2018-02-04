package com.implementation.algorithms.threading.demo;

// TODO: 04/02/18
// https://www.geeksforgeeks.org/multithreading-in-java/

public class ThreadExecution {

    public static void main(String[] args) {
        ThreadImpl impl1 = new ThreadImpl();
        ThreadImpl impl2 = new ThreadImpl();

        impl1.start();
        impl2.start();
    }

}
