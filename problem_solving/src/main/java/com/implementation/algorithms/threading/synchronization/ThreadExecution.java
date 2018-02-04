package com.implementation.algorithms.threading.synchronization;

// TODO: 04/02/18
// https://www.geeksforgeeks.org/synchronized-in-java/

public class ThreadExecution {

    public static void main(String[] args) {

        Message message = new Message();

        MessageSender messageSender1 = new MessageSender( message, "Server 1");
        MessageSender messageSender2 = new MessageSender( message, "Server 2");

        messageSender1.start();
        messageSender2.start();
    }

}
