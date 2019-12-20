package com.implementation.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    Node rootNode;

    public BST() {
        rootNode = null;
    }

    private Node addRecursively(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursively(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursively(current.right, value);
        } else {
            //value already exists
            return current;
        }

        return current;
    }

    private Node deleteRecursively(Node current, int value) {
        if(current == null) {
            return null;
        }

        if(value == current.value) {
            if(current.left == null && current.right == null) {
                current = null;
            } else if (current.left == null) {
                current = current.right;
            } else if (current.right == null) {
                current = current.left;
            } else {
                int valueToReplace = findLargestLeft(current.left);
                deleteNode(valueToReplace);
                current.value = valueToReplace;
            }
        } else if (value < current.value) {
            current.left = deleteRecursively(current.left, value);
        } else if (value > current.value) {
            current.right = deleteRecursively(current.right, value);
        }
        return current;
    }

    private int findLargestLeft(Node current) {
        int largest;
        largest = current.right == null ? current.value : findLargestLeft(current.right);
        return largest;
    }

    public void add(int value) {
        this.rootNode = addRecursively(rootNode, value);
    }

    public void inOrderTraversal(Node rootNode) {
        if (rootNode != null) {
            inOrderTraversal(rootNode.left);
            System.out.printf(rootNode.value + " ");
            inOrderTraversal(rootNode.right);
        }
    }

    public void preOrderTraversal(Node rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.value + " ");
            preOrderTraversal(rootNode.left);
            preOrderTraversal(rootNode.right);
        }
    }

    public void postOrderTraversal(Node rootNode) {
        if (rootNode != null) {
            postOrderTraversal(rootNode.left);
            postOrderTraversal(rootNode.right);
            System.out.print(rootNode.value + " ");
        }
    }

    public void breadthFirstSearch(Node rootNode) {
        Queue<Node> queue = new LinkedList<Node>();

        if (rootNode != null) {
            queue.add(rootNode);

            while (!queue.isEmpty()) {
                Node node = queue.remove();
                System.out.print(node.value + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public void deleteNode(int value) {
        deleteRecursively(this.rootNode, value);
    }

    private Node checkNodeRecursively(Node current, int value) {
        if(current == null) {
            return null;
        }

        if(value == current.value) {
           return current;
        }else if(value < current.value) {
            return checkNodeRecursively(current.left, value);
        } else  {
            return checkNodeRecursively(current.right, value);
        }
    }

    public boolean containsNode(int value) {
        boolean containsNode = false;
        Node findNode = checkNodeRecursively(this.rootNode, value);
        if (findNode != null) {
            containsNode = true;
        }
        return containsNode;
    }

    public static void main(String[] args) {
        BST bt = new BST();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        System.out.println("In order");
        bt.inOrderTraversal(bt.rootNode);
        System.out.println("");
        System.out.println("Pre order");
        bt.preOrderTraversal(bt.rootNode);
        System.out.println("");
        System.out.println("Post order");
        bt.postOrderTraversal(bt.rootNode);
        System.out.println("");
        System.out.println("BFS");
        bt.breadthFirstSearch(bt.rootNode);
        System.out.println("");

        if(bt.containsNode(8 ) == true) {
            bt.deleteNode(8);
            System.out.println("After deleting node");
            bt.inOrderTraversal(bt.rootNode);
        }
        
    }
}
