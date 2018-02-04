package com.implementation.algorithms.threading.producerconsumer;

import java.util.LinkedList;

public class ProducerConsumer {

    private LinkedList<Integer> values = new LinkedList<Integer>();
    private Integer listSize = 2;

    public void produce() throws InterruptedException {

        int value = 1;

        while (true) {

            synchronized (this) {

                if (values.size() == listSize) {
                    wait();
                }

                notify();

                System.out.println("Now adding value "+value+" to the list");
                values.add(value++);

                Thread.sleep(1000);
            }

        }

    }

    public void consume() throws InterruptedException {

        while (true) {

            synchronized (this) {

                if (values.size() == 0) {
                    wait();
                }

                int value = values.removeFirst();
                System.out.println("now removing element "+ value +" from the list");

                notify();

                Thread.sleep(1000);
            }

        }

    }

}
