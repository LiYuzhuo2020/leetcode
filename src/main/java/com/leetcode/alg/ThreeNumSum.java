package com.leetcode.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: drainli
 **/
public class ThreeNumSum {

    public class Auxilary{

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>() ;
        if(nums.length < 3){
            return ret ;
        }
        List<Integer> tmpList = null ;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1 ;
            int r = nums.length - 1 ;
            while(l < r){
                if(nums[l] == nums[l-1]){
                    l++;
                    continue;
                }
                if(nums[i] > 0 || nums[r] < 0){
                    return ret ;
                }
                if(nums[i] + nums[l] + nums[r] == 0){
                    tmpList = new ArrayList<>() ;
                    tmpList.add(nums[i]) ;
                    tmpList.add(nums[l]) ;
                    tmpList.add(nums[r]) ;
                    ret.add(tmpList) ;
                    l++;
                    r--;
                }else if(nums[i] + nums[l] + nums[r] < 0){
                    l++ ;
                }else if(nums[i] + nums[l] + nums[r] > 0){
                    r-- ;
                }
            }
        }
        return ret ;
    }

    public static void main(String[] args) {
        ThreeNumSum threeNumSum = new ThreeNumSum() ;
        System.out.println(threeNumSum.threeSum(new int[]{-2,0,0,2,2}));
        String s = "" ;
        //s.substring()
        char[] chars = s.toCharArray();
        int i= 9 ;
      //  String.valueOf()
        StringBuilder builder = new StringBuilder();
        System.out.println("a" + "b");
        System.out.println("b" + "a");
        String.valueOf(chars);
    }

}
