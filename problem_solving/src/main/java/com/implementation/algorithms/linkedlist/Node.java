package com.implementation.algorithms.linkedlist;
/*
    Todo - Linkedlist node
*/
public class Node {

    private Node next;
    private int nodeValue;

    Node(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

}
