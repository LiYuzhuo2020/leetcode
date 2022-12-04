package com.leetcode.alg;

/**
 * @Author: drainli
 **/
public class Solution35 {

    public static int searchInsert(int[] nums, int target) {
        int left =0,right = nums.length-1;
        while(left <= right){
            int mid  = (left + right) >> 1 ;
            if(target > nums[mid]){
                left = mid + 1;
            }else if(target == nums[mid]){
                return mid ;
            }else{
                right = mid ;
            }
        }

        return nums.length ;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,3,5,6} ;
        System.out.println(searchInsert(num,5));
    }

}
