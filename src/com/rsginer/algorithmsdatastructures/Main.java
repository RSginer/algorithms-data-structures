package com.rsginer.algorithmsdatastructures;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 3, 2, 9, 8, 7};
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }


        QuickSort quickSort = new QuickSort();
        int[] orderedIntArr = quickSort.sortIntArray(arr);
        List<Integer> orderedList = quickSort.sortIntegerList(list, 0, orderedIntArr.length - 1);

        for (int i = 0; i < orderedList.size(); i++) {
            System.out.println(orderedList.get(i));
        }

    }



}
