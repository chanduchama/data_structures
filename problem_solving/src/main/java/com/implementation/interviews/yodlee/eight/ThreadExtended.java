package com.implementation.interviews.yodlee.eight;

public class ThreadExtended extends Thread {
    public void run() {
        System.out.println("\n Thread is running now \n");
    }

    public static void main(String[] args) {
        ThreadExtended threadE = new ThreadExtended();
        threadE.start();
        // get threads count in current program
        System.out.println(Thread.activeCount());
    }
}
