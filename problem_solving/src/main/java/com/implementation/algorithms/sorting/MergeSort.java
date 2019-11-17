package com.implementation.algorithms.sorting;

/**
 * Merge sort algorithm
 * ToDo
 * Need to optimize the algorithm to reduce the space consumption
 */
public class MergeSort {

    public static void main(String[] args) {
        Integer[] numbers = {9,3,7,5,6,4,8,2};
        MergeSort mergeSort = new MergeSort();
        System.out.println("input array is");
        mergeSort.printArray(numbers);
        Integer[] sortedNumbers = mergeSort.performSorting(numbers);
        System.out.println("output array is");
        mergeSort.printArray(sortedNumbers);
    }

    private Integer[] performSorting(Integer[] numbers) {
        if (numbers.length >= 2) {
            Integer middle = (numbers.length/2)-1;
            Integer[] leftArray = getSubArray(numbers, 0, middle);
            Integer[] rightArray = getSubArray(numbers, middle+1, numbers.length-1);
            if(leftArray.length > 1)
                leftArray = performSorting(leftArray);
            if(rightArray.length > 1)
                rightArray = performSorting(rightArray);
            numbers = merge(leftArray, rightArray);
        }
        return numbers;
    }

    public void printArray(Integer[] numbers) {
        for (Integer numb: numbers) {
            System.out.print(numb + " ");
        }
        System.out.println("");
    }

    private Integer[] getSubArray(Integer[] numbers, Integer i, Integer middle) {
        Integer[] subArray = new Integer[(middle-i)+1];
        Integer count = 0;
        for (Integer index = i; index <= middle; index++) {
            subArray[count++] = numbers[index];
        }
        return subArray;
    }

    private Integer[] merge(Integer[] array1, Integer[] array2) {
        Integer[] mergedArray = new Integer[array1.length+array2.length];

        boolean merged = false;
        Integer index1 = 0;
        Integer index2 = 0;
        Integer mergedIndex = 0;
        while (!merged) {
            if(index1 < array1.length && index2 < array2.length) {
                if(array1[index1] <= array2[index2]) {
                    mergedArray[mergedIndex++] = array1[index1++];
                } else {
                    mergedArray[mergedIndex++] = array2[index2++];
                }
            } else if(index1 < array1.length) {
                mergedArray[mergedIndex++] = array1[index1++];
            } else if(index2 < array2.length) {
                mergedArray[mergedIndex++] = array2[index2++];
            } else {
                merged = true;
            }
        }

        return mergedArray;
    }

}
