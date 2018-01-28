package com.implementation.algorithms.dynamic_programming;

// TODO: 28/01/18
/*
LCS Problem Statement:
Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
*/

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence();

        String firstString = "AGGTABHELLO";
        String secondString = "GXTXAYBHO";

        int lcs = longestCommonSubSequence.findLcs(firstString, secondString);
        System.out.println("Longest common subsequence length is : " + lcs);

        String lcsString = longestCommonSubSequence.findLcsString(firstString, secondString);
        System.out.println("Longest common subsequence string is : " + lcsString);
    }

    public String findLcsString(String firstString, String secondString){
        int[][] lcsMatrix = createLcsMatrix(firstString, secondString);

        char[] firstCharArray = firstString.toCharArray();
        char[] secondCharArray = secondString.toCharArray();

        int i = firstString.length();
        int j = secondString.length();

        int lcsLength = lcsMatrix[i][j];
        int lcsIndex = lcsLength;
        char[] lcsString = new char[lcsLength];

        while( i>0 && j>0 ) {

            if ( firstCharArray[i-1] == secondCharArray[j-1] ) {
                lcsString[lcsIndex-1] = firstCharArray[i-1];
                i--;
                j--;
                lcsIndex--;
            } else if ( lcsMatrix[i][j-1] > lcsMatrix[i-1][j] ){
                j--;
            } else {
                i--;
            }

        }

        return  String.valueOf(lcsString);
    }

    public int findLcs(String firstString, String secondString) {
        int lcs = 0;

        System.out.println("First string is : "+firstString);
        System.out.println("Second string is : "+secondString);

        int[][] lcsMatrix = createLcsMatrix(firstString, secondString);
        System.out.println("LCS matrix is : ");

        // uncomment this line to print the matrix
        // printMatrix(lcsMatrix, firstString.length()+1, secondString.length()+1);

        lcs = lcsMatrix[firstString.length()][secondString.length()];

        return lcs;
    }

    public int[][] createLcsMatrix(String firstString, String secondString) {

        char[] firstCharArray = firstString.toCharArray();
        char[] secondCharArray = secondString.toCharArray();

        int firstStrLength = firstCharArray.length;
        int secondStrLength = secondCharArray.length;

        int[][] lcsMatrix = new int[firstStrLength+1][secondStrLength+1];

        for (int i = 0; i <= firstStrLength; i++) {
            for (int j = 0; j <= secondStrLength; j++) {
                if (i == 0 || j == 0) {
                    lcsMatrix[i][j] = 0;
                } else if (firstCharArray[i - 1] == secondCharArray[j - 1]) {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i][j - 1], lcsMatrix[i - 1][j]);
                }
            }
        }

        return lcsMatrix;
    }

    private void printMatrix(int[][] matrix, int rowLength, int colLength) {

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("  ");
            }
            System.out.println("");
        }

    }
}
