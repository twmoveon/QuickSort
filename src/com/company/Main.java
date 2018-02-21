package com.company;

import java.io.*;
import java.util.Arrays;

public class Main {

    private static int N = 32768;
    private static String path = "/Users/wuxiaodong/Downloads/dataset-problem2-hw2/data1.32768";
    public static void main(String[] args) throws IOException {
        // write your code here
        int[] array = loadArray();
        int[] array2= loadArray();
        QuickSort quickSort = new QuickSort();
        MergeSort1 mergeSort1 = new MergeSort1();

        long startTime=System.currentTimeMillis();  //Get the start time
        quickSort.sort(array,0,array.length - 1);
        long endTime=System.currentTimeMillis();    //Get the end time
        String time ="Run Time: "+(endTime-startTime)+"ms";
        System.out.println(Arrays.toString(array));
        System.out.println("The cost time in QuickSort: " + time);

        long startTime2=System.currentTimeMillis();  //Get the start time
        mergeSort1.sort(array2);
        long endTime2=System.currentTimeMillis();    //Get the end time
        String time2 = "Run Time: "+(endTime2-startTime2)+"ms";
        System.out.println(Arrays.toString(array2));
        System.out.println("The cost time in MergeSort: " + time2);

    }

    public static int[] loadArray() throws IOException {
        int[] array = new int[N];
        File filename = new File(path);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename)); // Create a reader object
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        int i = 0;
        while (line != null && i < array.length) {
            line = br.readLine(); // Read each line
            if(line != null)
                array[i] = Integer.parseInt(line);
            i++;
        }
        return array;
    }


}
