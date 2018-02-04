package com.implementation.algorithms.threading.synchronization;

public class Message {

    // Synchronization can be at a method level also like this
    // public synchronized void printSequence(String serverName) {
    public void printSequence(String serverName) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(" message number "+ i +" from " + serverName);
                Thread.sleep(1000);
            }
        }
    }

}
