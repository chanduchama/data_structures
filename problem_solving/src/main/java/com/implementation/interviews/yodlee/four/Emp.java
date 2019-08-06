package com.implementation.interviews.yodlee.four;

import java.io.Serializable;

public class Emp implements Serializable {
    private static final long serialversionIOD = 129348938L;
    transient int a;
    static int b;
    String name;
    int age;

    public Emp(String name, int age, int a,int b) {
        this.a = a;
        this.name = name;
        this.age = age;
        this.b = b;
    }
}
