package com.leetcode.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: drainli
 **/
public class _170_TwoSum {

    private List<Integer> nums = new ArrayList<>() ;

    public _170_TwoSum() {

    }

    public void add(int number) {
        this.nums.add(number) ;
    }

    public boolean find(int value) {
        if(this.nums.size() < 2){
            return false ;
        }
        Collections.sort(this.nums, Comparator.comparingInt(o -> o)) ;
        int l=0,r=nums.size()-1;
        for(;l<r;){
            if(this.nums.get(l) + this.nums.get(r) == value ){
                return true ;
            }else if(this.nums.get(l) + this.nums.get(r) < value ){
                l++ ;
            }else if(this.nums.get(l) + this.nums.get(r) > value ){
                r -- ;
            }
        }

        return false ;
    }

}
