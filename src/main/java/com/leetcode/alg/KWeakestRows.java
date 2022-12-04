package com.leetcode.alg;

import java.util.*;

/**
 * @Author: drainli
 **/
public class KWeakestRows {

    public static int[] kWeakestRows(int[][] mat, int k) {
        if (mat.length<=0 || k == 0){
            return new int[]{} ;
        }
        int[] sortIndex = new int[k] ;
        Map<int[],Integer> rowMapping = new HashMap<>() ;
        for(int i=0;i<mat.length;i++){
            rowMapping.put(mat[i],i) ;
        }
        Arrays.parallelSort(mat, Comparator.comparingInt(KWeakestRows::sum));
        for (int i=0;i<k;i++){
            sortIndex[i] = rowMapping.get(mat[i]);
        }

        return sortIndex ;
    }

    private static int sum(int[] arr){
        return Arrays.stream(arr).parallel().sum();
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[] sortIndex = kWeakestRows(mat,3) ;
        Arrays.stream(sortIndex).forEach(d -> System.out.print(d+" "));
    }

}
