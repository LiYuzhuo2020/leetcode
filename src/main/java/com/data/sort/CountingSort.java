package com.data.sort;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class CountingSort {

    public void sort(int[] nums){
        int n = nums.length ;
        int maxNum = Integer.MIN_VALUE ;
        for (int i=0;i<n;i++){
            maxNum = Math.max(maxNum,nums[i]) ;
        }

        int[] c = new int[maxNum+1] ;
        for (int i=0;i<n;i++){
            c[nums[i]] ++ ;
        }

        for (int i=1;i<=maxNum;i++){
            c[i] = c[i-1] + c[i] ;
        }
        int[] r = new int[n] ;
        for (int i=n-1;i>=0;i--){
            r[c[nums[i]]-1] = nums[i] ;
            c[nums[i]]--;
        }

        System.arraycopy(r, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,7,8,0,2,3,4} ;
        new CountingSort().sort(nums);
        Arrays.stream(nums).forEach(d -> System.out.print(d+" "));
        StringBuilder sb = new StringBuilder() ;
        sb.append("a") ;
        sb.append("b") ;
        sb.reverse();

        System.out.println(sb);
    }

}
