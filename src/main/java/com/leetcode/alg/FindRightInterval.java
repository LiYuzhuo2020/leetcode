package com.leetcode.alg;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: drainli
 **/
public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
       int length = intervals.length; ;
       int[][] startIntervals = new int[length][2] ;
       for (int i=0;i<length;i++){
           startIntervals[i][0] = intervals[i][0] ;
           startIntervals[i][1] = i ;
       }
        int[] ret = new int[length] ;
        Arrays.sort(startIntervals, Comparator.comparingInt(arr -> arr[0]));
        for (int i=0;i<length;i++){
            int target =  -1 ;
            int left = 0, right = length - 1 ;
            while (left <= right){
                int mid = (right - left) >> 1 + left ;
                if (startIntervals[mid][0] >= intervals[left][1]){
                    right = mid - 1 ;
                    target = startIntervals[mid][1] ;
                }else {
                    left = mid + 1 ;
                }
            }
            ret[i] = target ;
        }

        return ret ;
    }

    public static void main(String[] args) {

    }

}
