package com.implementation.algorithms.threading.InterThreadCom;

public class ThreadExecution {

    public static void main(String[] args) throws InterruptedException {

        final ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {

                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}
