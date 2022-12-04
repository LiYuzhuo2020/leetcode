package com.leetcode.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: drainli
 **/
public class Solution20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray() ;
        if (chars.length <= 1){
            return false ;
        }
        Stack<Character> stack = new Stack<Character>() ;
        for (int i=0;i<chars.length;i++){
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                // push
                stack.push(chars[i]) ;
            }
            if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}'){
                // pop
                if (stack.size() == 0){
                    return false ;
                }else if (!isMatch(stack.pop(),chars[i])){
                    return false ;
                }
            }

        }
            return true ;
    }

    private boolean isMatch(char c1,char c2){
        if (c1 == '(' && c2 == ')'){
            return true ;
        }else if (c1 == '[' && c2 == ']'){
            return true ;
        }else if (c1 == '{' && c2 == '}'){
            return true ;
        }else {
            return  false ;
        }
    }

    public static void main(String[] args) {
//        String kmp = "[" ;
//        Solution20 solution20 = new Solution20() ;
//        System.out.println(solution20.isValid(kmp));

        List<Integer> nums = new ArrayList<>() ;
        nums.add(5) ;
        nums.toArray(new Integer[0]);

        int[] t = new int[nums.size()] ;
       // nums.stream().forEach((i,n) -> t[i] = n);
        System.out.println(Integer.bitCount(2)) ;
    }

}
