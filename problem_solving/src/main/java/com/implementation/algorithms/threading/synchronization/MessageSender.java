package com.implementation.algorithms.threading.synchronization;

public class MessageSender extends Thread {

    private String serverName;
    private Message messageSync;

    public MessageSender(Message messageSync, String serverName) {
        this.serverName = serverName;
        this.messageSync = messageSync;
    }

    public void run() {
        try {
            this.messageSync.printSequence(serverName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
