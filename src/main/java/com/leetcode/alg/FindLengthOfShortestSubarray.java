package com.leetcode.alg;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class FindLengthOfShortestSubarray {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length ;
        int left=0,right=n-1;
        while(left < n-1 && arr[left] <= arr[left+1]) left++ ;
        while(right>=1 && arr[right] >= arr[right-1]) right--;
        if(left==n || left>right){
            return 0 ;
        }
        int ans = right;
        for(int i=0;i<=left;i++){
            int k = arr[i] ;
            int l = right,r=n;
            while (l<r) {
                int mid = (l+r)>>1;
                if (arr[mid] < k) {
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
                ans = Math.min(ans,l-i-1) ;
        }

        return ans ;
    }

    private int searchLowIndex(int[] arr, int right, int i, int k) {
        int l = right,r = i ;
        while (l <= r){
            int mid = (l + r) >> 1 ;
            if (arr[mid]<k){
                return mid ;
            }else {
                r = mid - 1 ;
            }
        }

        return -1 ;
    }

    public static void main(String[] args) {
        FindLengthOfShortestSubarray test = new FindLengthOfShortestSubarray() ;
        int result = test.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}) ;
        System.out.println(result);
    }

}
