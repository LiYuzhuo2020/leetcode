package com.leetcode.alg;

/**
 * @Author: drainli
 **/
public class ReverseStr {

    public int reverseNum(int x){
       int res = 0, t = 0 ;
       while (x != 0 ){
           t = x % 10 ;
           res = res * 10 + t ;
           x /= 10 ;
       }
       if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE){
           return  0 ;
       }

       return res ;
    }

}
