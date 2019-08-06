package com.implementation.interviews.yodlee.one;

import java.io.IOException;

public class Test extends Derived {
    // overriding method should always follow the signature of the parent method including the exception return types
    public void getDetails() throws IOException {
        System.out.println("Main Class");
    }

    public static void main(String[] args) throws IOException {
        Derived obj = new Test();
        obj.getDetails();
    }
}
