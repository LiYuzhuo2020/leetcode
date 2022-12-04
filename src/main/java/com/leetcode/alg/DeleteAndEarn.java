package com.leetcode.alg;


import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,3,4} ;
        Arrays.parallelSort(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }

}
