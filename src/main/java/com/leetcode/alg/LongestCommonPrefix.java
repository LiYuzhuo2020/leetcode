package com.leetcode.alg;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // 排序
        Arrays.sort(strs,0,strs.length);
        if (strs.length<=1){
            return strs[0] ;
        }
        return longestPrefix(strs[0],strs[1]) ;
    }

    private String longestPrefix(String str1,String str2){
        String prefix = "" ;
        for (int i=0;i<Math.min(str1.length(),str2.length());i++){
            if (str1.charAt(i) == str2.charAt(i)){
                prefix += str1.charAt(i) ;
            }else {
                break;
            }
        }

        return prefix ;
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix() ;
        String[] strs = {"flower","flow","flight"} ;
        System.out.println(prefix.longestCommonPrefix(strs));
    }

}
