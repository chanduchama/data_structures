package com.implementation.algorithms.linkedlist;

/*
    Todo - Floyd's cycle detection algorithm
*/

public class CycleDetection {

    public boolean detectAndRemoveLoop(Node head) {

        Node slow = head;
        Node fast = head;
        Boolean kontinue = true;

        while(slow != null && fast != null && kontinue) {

            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if( slow.getNodeValue() == fast.getNodeValue() ) {
                System.out.println("found the cyclic dependency common node at : "+ slow.getNodeValue());
                System.out.println("now trying to remove cyclic dependency " );
                removeCyclicDependency(head,fast);
                kontinue = false;
            }
        }

        return true;
    }

    public void removeCyclicDependency(Node head, Node commonNode) {

        Node ptr1 = head;

        Node ptr2 = null;

        boolean kontinue = true;

        while (kontinue) {

            ptr2 = commonNode;

            while ( ptr2.getNext() != ptr1 && ptr2.getNext() != commonNode ) {
                ptr2 = ptr2.getNext();
            }

            if( ptr2.getNext() == ptr1 ) {
                break;
            }

            ptr1 = ptr1.getNext();

        }

        ptr2.setNext(null);

    }

}
