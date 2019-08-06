package com.implementation.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class ArrayBug {

    public static void main(String[] args) {
        System.out.println((1%4));
        ArrayBug arrayBug = new ArrayBug();
        /*ArrayList<Integer> sampleInput = new ArrayList<Integer>();
        sampleInput.add(5);
        sampleInput.add(10);
        sampleInput.add(2);
        sampleInput.add(one);
        List<Integer> modifiedOutput = arrayBug.performOps(sampleInput);
        for (Integer value : modifiedOutput) {
            System.out.println(value);
        }*/
    }

    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            System.out.println(A.get(i + B));
            ret.add(A.get(i + B));
        }
        return ret;
    }

    public ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }

}
