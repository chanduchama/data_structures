package com.implementation.algorithms.stack.com.implementation.algorithms.stack;

//Implementing a dynamic stack with string array
public class DynamicStack {

    private String[] stack;

    public DynamicStack() {
        stack = new String[0];
    }

    // code for increasing the stack size dynamically
    public int push(String word) {
        int stackLength = -1;

        if(stack.length == 0) {
            stack = new String[1];
        } else {
            String[] tmpStack = new String[stack.length+1];
            for(int stackIndex=0;stackIndex<stack.length;stackIndex++) {
                tmpStack[stackIndex] = stack[stackIndex];
            }
            stack = tmpStack;
        }
        stack[stack.length-1] = word;
        stackLength = stack.length;

        return stackLength;
    }

    // code for shrinking the stack size dynamically
    public String pop() throws Exception {
        String word;

        if(stack.length == 0) {
            throw new Exception("Error, cannot pop element from empty stack");
        } else {
            word = stack[stack.length-1];
            String[] tmpStack = new String[stack.length-1];
            for(int stackIndex=0;stackIndex<stack.length-1;stackIndex++) {
                tmpStack[stackIndex] = stack[stackIndex];
            }
            stack = tmpStack;
        }

        return word;
    }

    // returns stack size
    public int getStackSize() {
        return stack.length;
    }

    // print all elements of the stack
    public void printStack() {
        for (String word: stack) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        DynamicStack dynamicStack = new DynamicStack();

        // Initial stack size
        System.out.println(dynamicStack.getStackSize());

        // Stack push
        System.out.println(dynamicStack.push("hey"));
        System.out.println(dynamicStack.push("hi"));

        //stack pop
        try {
            System.out.println(dynamicStack.pop());
            System.out.println(dynamicStack.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }

        dynamicStack.printStack();
    }

}
