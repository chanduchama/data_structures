package com.implementation.algorithms.threading.InterThreadCom;

import java.util.Scanner;

public class ProducerConsumer {

    public void produce() throws InterruptedException {

        synchronized (this) {
            System.out.println("Now started the producer method");

            System.out.println("Now sending the consumer method to wait mode");
            wait();

            System.out.println("Now resuming the produce method");

            System.out.println("now finishing the producer method");
        }

    }

    public void  consume() throws InterruptedException {
        // Sleeping consumer method for first starting the produce method
        Thread.sleep(1000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("now starting the consumer method");
            System.out.println("waiting for the input from the user");
            System.out.println("Please hit the enter button");
            scanner.nextLine();

            notify();

            Thread.sleep(1000);

            System.out.println("Now finishing the consumer method");
        }

    }

}
