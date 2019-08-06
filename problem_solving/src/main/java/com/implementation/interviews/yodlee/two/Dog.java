package com.implementation.interviews.yodlee.two;

public class Dog extends Animal {
    static void fun() {
        System.out.println("Dog");
    }

    // static methods are always local to the actual class but not the type of instance class
    public static void main(String[] args) {
        Animal a = new Dog();
        Dog d = new Dog();
        a.fun();
        d.fun();
    }
}
