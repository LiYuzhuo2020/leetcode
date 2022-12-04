package com.data.sort;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class QuickSort<E extends Comparable<E>> {

    public void quickSort(E[] arr,int l,int r){
        if (l>=r)return;
        int p = partition(arr,l,r) ;
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    private int partition(E[] arr,int l,int r){
        int i=l,j=l+1;
        while (j<=r){
            if (arr[j].compareTo(arr[l])<0){
                swap(++i,j,arr);
            }
           j++;
        }

        swap(i,l,arr);

        return i ;
    }

    private void swap(int i,int j,E[] arr){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t ;
    }

    public static void main(String[] args) {
        QuickSort<Integer> sort = new QuickSort<>() ;
        Integer[] arr = new Integer[]{1,9,8,7,6,5,4,3,2,99,9,9,9} ;
        sort.quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(num -> {
            System.out.print(num+" ");
        });

        System.out.println();
    }

}
