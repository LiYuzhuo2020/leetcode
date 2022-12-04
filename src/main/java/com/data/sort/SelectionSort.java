package com.data.sort;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class SelectionSort<E extends Comparable<E>> {

    public void selectionSort(E[] arr){
        for (int i=0;i<arr.length;i++){
            int minIndex = i ;
            for (int j=i;j<arr.length-1;j++){
                if(arr[minIndex].compareTo(arr[j+1])>0){
                    minIndex = ++j ;
                }
            }
            swap(minIndex,i,arr);
        }
    }

    private void swap(int i,int j,E[] arr){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t ;
    }

    public static void main(String[] args) {
        SelectionSort<Integer> sort = new SelectionSort<>() ;
        Integer[] arr = new Integer[]{1,9,8,7,6,5,4,3,2} ;
        sort.selectionSort(arr);
        Arrays.stream(arr).forEach(num -> {
            System.out.print(num+" ");
        });

        System.out.println();
    }

}
