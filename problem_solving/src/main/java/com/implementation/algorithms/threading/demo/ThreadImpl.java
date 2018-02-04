package com.implementation.algorithms.threading.demo;

public class ThreadImpl extends Thread {

    public void run() {
        System.out.println("Cool, now running the thread with id ");
        System.out.println(Thread.currentThread().getId());
    }

}
