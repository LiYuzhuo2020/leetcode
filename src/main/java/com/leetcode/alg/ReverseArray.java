package com.leetcode.alg;

/**
 * <p>
 *     力扣翻转数组
 * </p>
 *
 * @Author: drainli
 **/
public class ReverseArray {

    public void rotate(int[] nums, int k) {
        int[] auxiliaryArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            auxiliaryArray[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = nums[i];
        }
    }

    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray() ;
        System.out.println(reverseArray.gcd(5,-3));
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}
