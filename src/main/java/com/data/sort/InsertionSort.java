package com.data.sort;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class InsertionSort<E extends Comparable<E>> {

    public void insertionSort(E[] arr){
        int n = arr.length ;
        if (n <= 1){
            return;
        }
        for (int i=1;i<n;i++){
            for (int j=i;j>0;j--){
                if (arr[j].compareTo(arr[j-1])<0){
                    swap(j,j-1,arr);
                }
            }
        }
    }

    private void swap(int i,int j,E[] arr){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t ;
    }

    public static void main(String[] args) {
        InsertionSort<Integer> sort = new InsertionSort<>();
        Integer[] arr = new Integer[]{1,3,2,6,5,4,9,9} ;
        sort.insertionSort(arr);

        Arrays.stream(arr).forEach(num -> System.out.print(num+" "));
    }

}
