package com.implementation.algorithms.linkedlist;

/*
    Todo - Code execution
*/

public class Driver {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        linkedList.head = n1;
        linkedList.setTailNode(n2);
        linkedList.setTailNode(n3);
        linkedList.setTailNode(n4);
        linkedList.setTailNode(n5);
        linkedList.setTailNode(n6);
        linkedList.setTailNode(n7);
        linkedList.setTailNode(n8);
        linkedList.setTailNode(n9);
        linkedList.setTailNode(n10);

        // adding a cyclic loop at node 4
        n10.setNext(n4);

        CycleDetection cycleDetection = new CycleDetection();

        cycleDetection.detectAndRemoveLoop(linkedList.head);

        linkedList.printList();
    }

}
