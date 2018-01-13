package com.implementation.algorithms.linkedlist;

/*
    Todo - Linked List Class
*/

public class LinkedList {

    Node head;

    public void printList() {
        Node currentNode = head;
        do {

            System.out.println(currentNode.getNodeValue() + "");
            System.out.println("-->");

            currentNode = currentNode.getNext();

        } while( currentNode != null );
    }

    public void setTailNode(Node node) {
        Node currentNode = head;
        do {

            if( currentNode.getNext() == null ) {
                currentNode.setNext(node);
                currentNode = currentNode.getNext();
            }

            currentNode = currentNode.getNext();

        } while( currentNode != null );
    }

}
