package com.company;


public class QuickSort {
    private int CUTOFF = 7;
    private int count = 0;
    public void sort(int[] array,int left, int right){
        if(left < right) {
            if(right - left + 1 <= CUTOFF){
                InsertionSort(array,left,right);
                return;
            }

            int j = partition(array, left, right);  //do partition and get the pivot
            sort(array, left, j - 1);   //sort the left sub array of the pivot
            sort(array, j + 1, right);  //sort the right sub array of the pivot
        }
    }

    private  int partition(int[] a, int lo, int hi) {

        int p1 = lo, p2 = (hi - lo) / 2 + lo, p3 = hi;  //three pivot candidates
        int pivot = findMedian(a,p1,p2,p3);     //use median-of-three to find the pivot
        swap(a,pivot,lo);   //swap the pivot with the first value
        int i = lo, j = hi + 1;
        while (true) {  //do the partition

            while (a[++i] < a[lo]) {
                count++;
                if (i == hi) break;
            }
            while (a[lo] < a[--j]) {
                count++;
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j); //swap the pivot with the a[j]
        return j;
    }

    private void swap(int[] a, int i, int j){   //swap function
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private int findMedian(int[]array, int a, int b, int c){    //find median function
        return (array[a] < array[b] ? (array[b] < array[c] ? b : array[a] < array[c] ? c : a)
                : (array[b] > array[c] ? b : array[a] > array[c] ? c : a));
    }
    public void InsertionSort(int[] a, int left, int right) {
        int i, j, k;
        for (i = left+1; i < right+1; i++) {
            for (j = i - 1; j >= 0; j--) {
                count++;
                if (a[j] < a[i]) {
                    count++;
                    break;
                }
            }
            if (j != i - 1) {
                int temp = a[i];
                for (k = i - 1; k > j; k--) {
                    a[k + 1] = a[k];
                }
                a[k + 1] = temp;
            }
        }
    }
}
