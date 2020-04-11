package com.rsginer.algorithmsdatastructures;

import java.util.Collections;
import java.util.List;

public class QuickSort {

    int[] lastIntJob;
    List<Integer> lastListJob;

    public int[] sortIntArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        this.lastIntJob = quickSortIntArray(arr, start, end);
        return this.lastIntJob;
    }

    public int[] quickSortIntArray (int[] arr, int start, int end) {
        if (arr == null || arr.length == 0)
            return arr;

        if (start >= end)
            return arr;

        int middle = start + (end - start) / 2;
        int pivot = arr[middle];
        int i = start, j = end;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (start < j)
            quickSortIntArray(arr, start, j);

        if (end > i)
            quickSortIntArray(arr, i, end);

        return arr;
    }

    public static List<Integer> sortIntegerList(List<Integer> list, int start, int end) {
        if (list == null || list.size() == 0)
            return list;

        if (start >= end)
            return list;

        int middle = start + (end - start) / 2;
        int pivot = list.get(middle);
        int i = start, j = end;

        while (i <= j) {
            while (list.get(i) < pivot) {
                i++;
            }

            while (list.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                Collections.swap(list, i, j);
                i++;
                j--;
            }
        }

        if (start < j)
            sortIntegerList(list, start, j);

        if (end > i)
            sortIntegerList(list, i, end);

        return list;
    }

    public static void swap (int[] arr, int a, int b) {
        int aux = arr[a];

        arr[a] = arr[b];
        arr[b] = aux;
    }
}
