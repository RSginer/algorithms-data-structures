package com.rsginer.algorithmsdatastructures;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 3, 2, 9, 8, 7};

        QuickSort quickSort = new QuickSort();
        quickSort.sortIntArray(arr);

        System.out.println(quickSort.toString());
    }



}
