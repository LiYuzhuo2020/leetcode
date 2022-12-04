package com.leetcode.alg;

/**
 * @Author: drainli
 **/
public class ReverseString {

    /**
     *  use stack
     * @param s
     * @return
     */
//    public static char[] reverseString(char[] s) {
//        Stack<Character> stack = new Stack<>() ;
//        for (char c : s){
//            stack.push(c) ;
//        }
//        s = new char[s.length] ;
//        int index = 0 ;
//        while (!stack.isEmpty()){
//            s[index++] = stack.pop() ;
//        }
//
//        return s ;
//    }

    /**
     *  use double ptr
     * @param s
     */
    public static char[] reverseString(char[] s) {
        int n = s.length ;
        int i = 0,j = n-1,mid = n / 2;
        while (i <= mid && j >= mid){
            char temp = s[i] ;
            s[i] = s[j] ;
            s[j] = temp ;
            i++;
            j--;
        }

        return s ;
    }

    public static void main(String[] args) {
        char[] s = {'a','b','c','d'} ;
        char[] reverse = reverseString(s) ;
        for (char c : reverse){
            System.out.print(c + " ");
        }
    }

}
