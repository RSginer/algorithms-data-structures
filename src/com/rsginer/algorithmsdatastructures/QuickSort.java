package com.rsginer.algorithmsdatastructures;

public class QuickSort {

    int[] lastJob;

    public void sortIntArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        this.lastJob = quickSortIntArray(arr, start, end);
    }

    public static int[] quickSortIntArray (int[] arr, int start, int end) {
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

    public static void swap (int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

    @Override
    public String toString() {
        String s = "[";

        for (int i = 0; i < this.lastJob.length; i++) {
            s += this.lastJob[i] + "" + (i != this.lastJob.length -1 ? "," : "");
        }

        s += "]";

        return s;
    }
}
