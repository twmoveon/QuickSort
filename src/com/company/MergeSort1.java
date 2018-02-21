package com.company;

public class MergeSort1 {

    private int[]array;
    private int[] extraArray;
    private int count = 0;

    public void sort(int input[]) {
        this.array = input;
        this.extraArray = new int[input.length];
        doMergeSort(0, input.length- 1);
        System.out.println("The number of comparision in MergeSort1 is: " + count);
    }

    public void doMergeSort(int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2; //divide the array into 2 parts
            doMergeSort(left, middle);  //divide the left sub array
            doMergeSort(middle + 1, right); //divide the right sub array
            mergeParts(left, middle, right);    //merge the array
        }
    }
    public void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            extraArray[i] = array[i];       //save values into a temp array
        }
        int i = lowerIndex, j = middle + 1,k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (extraArray[i] <= extraArray[j]) {
                array[k] = extraArray[i];
                i++;
            } else {
                array[k] = extraArray[j];
                j++;
            }
            count++;
            k++;
        }
        while (i <= middle) {
            array[k] = extraArray[i];
            k++;
            i++;
        }

    }
}
