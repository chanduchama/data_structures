package com.implementation.algorithms.caching;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU cache stand for Least Recently Used Cache. which evict least recently used entry.
 */
public class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        int value = -1;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            value = node.value;

            removeNodeFromList(node);
            setNodeHeader(node);
        }

        printQueue(head);

        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            removeNodeFromList(node);
            setNodeHeader(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                removeNodeFromList(end);
            }
            map.put(key, node);

            setNodeHeader(node);
        }

        printQueue(head);
    }

    private void removeNodeFromList(Node node) {
        if (node.previous != null && node.next != null) {
            Node previous = node.previous;
            Node next = node.next;
            previous.next = next;
            next.previous = node.previous;
        } else if (node.previous == null && node.next == null) {
            head = null;
        } else if (node.next == null) {
            Node previous = node.previous;
            previous.next = null;
            end = previous;
        } else if (node.previous == null) {
            head = node.next;
        }
    }

    private void setNodeHeader(Node node) {
        if (head == null) {
            head = node;
            end = node;
        } else {
            node.next = head;
            head.previous = node;
            node.previous = null;
            head = node;
        }
    }

    private void print(Node node) {
        System.out.print("(" + node.key + "," + node.value + ") --> ");
        if (node.next != null) {
            print(node.next);
        }
    }

    private void printQueue(Node node) {
        if (node != null) {
            print(node);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        lruCache.put(6, 6);

        System.out.println(lruCache.get(-1));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));

        lruCache.put(10, 10);
        lruCache.put(11, 11);
        lruCache.put(12, 12);
        lruCache.put(13, 13);
    }

}
