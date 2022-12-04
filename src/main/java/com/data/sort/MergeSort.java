package com.data.sort;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class MergeSort {

    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr,int  l,int r){
        if (l>=r) return;
        int mid = l + (r -l )/2 ;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static <E extends Comparable<E>> void  merge(E[] arr,int l,int mid,int r){
        E[] aux = Arrays.copyOfRange(arr,l,r+1) ;
       int i=l,j=mid+1 ;
        for (int k=l;k<=r;k++){
            if (i>mid){
                arr[k] = aux[j-l] ;
                j++ ;
            }
            if (j>r){
                arr[k] = aux[i-l];
                i++ ;
            }
            if (i<=mid && j<=r && aux[i-l].compareTo(aux[j-l]) < 0){
                arr[k] = aux[i-l];
                i++;
            }else if(i<=mid && j<=r && aux[j-l].compareTo(aux[i-l]) < 0){
                arr[k] = aux[j-l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,9,8,7,6,5,4,3,2,99,9,9,9} ;
       MergeSort.sort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(num -> {
            System.out.print(num+" ");
        });

        System.out.println();
    }

}
