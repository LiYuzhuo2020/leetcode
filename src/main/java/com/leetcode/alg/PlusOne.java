package com.leetcode.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     力扣数组相加
 * </p>
 * @Author: drainli
 **/
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int d = digits.length;
        int r = digits[d-1] + 1 >= 10 ? d+1 : d ;
        int[] ret = new int[r] ;
        ret[r-1] = ( digits[d-1] + 1 ) % 10 ;
        int carry = (digits[d-1] + 1) / 10 ;
        if (d < 2){
           if (r > d){
               ret[r-2] = carry ;
               return ret ;
           }

           return ret ;
        }
        for(int i=digits.length-2 ; i >= 0 ; i--) {
            ret[i] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        ret[0] += carry ;
        return ret ;
    }

    public static void main(String[] args) {
        int[] digits = {9,9} ;
        int[] ret = plusOne(digits) ;

        for (int num : ret){
            System.out.print(num + " ");
        }
    }

}
