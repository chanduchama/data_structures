package com.implementation.algorithms.dynamic_programming;

/*
 Imagine you have a collection of N wines placed next to each other on a shelf. For simplicity, let's number the wines from left to right as they are standing on the shelf with integers from one to N, respectively. The price of the i-th wine is pi (prices of different wines can be different).
 Because the wines get better every year, supposing today is the year one, on year y the price of the i-th wine will be y*pi, i.e. y-times the value that current year.
 You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year. One more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf and you are not allowed to reorder the wines on the shelf (i.e. they must stay in the same order as they are in the beginning).
 You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order.
 So for example, if the prices of the wines are (in the order as they are placed on the shelf, from left to right): p1=one, p2=4, p3=2, p4=3
 The optimal solution would be to sell the wines in the order p1, p4, p3, p2 for a total profit one*one + 3*2 + 2*3 + 4*4 = 29
 */

public class WinesMaximumProfit {

    public static void main(String[] args) {
        WinesMaximumProfit winesMaximumProfit = new WinesMaximumProfit();
        // int[] wines = {2,3,5,one,4};
        int[] wines = {1,4,2,3};
        int maxProfit = winesMaximumProfit.getMaximumProfit(wines);
        System.out.println("maximum profit for wines is : "+ maxProfit);
    }

    public int getMaximumProfit(int[] wines) {
        int starting = 0;
        int ending = wines.length-1;
        int year = 1;

        int maxProfit = calculateMaximumProfit(wines, year, starting, ending);
        return  maxProfit;
    }

    private int calculateMaximumProfit(int[] wines, int year, int starting, int ending) {
        int maximumProfit;
        if( starting > ending ) {
            maximumProfit = 0;
        } else {
            maximumProfit = Math.max(
                    ( calculateMaximumProfit( wines, year+1, starting+1, ending ) + wines[starting] * year ),
                    ( calculateMaximumProfit( wines, year+1, starting, ending-1 ) + wines[ending] * year )
            );
        }
        return  maximumProfit;
    }

}
