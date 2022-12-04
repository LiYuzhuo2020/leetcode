package com.leetcode.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: drainli
 **/
public class GetAllParenthesis {

    /**
     *  回溯法
     */
//    public List<String> generateParenthesis(int n) {
//        // 回溯法解决此题
//        List<String> compeletions = new ArrayList<>() ;
//        backtrack(new StringBuilder(),0,2*n,compeletions,0,0);
//        return compeletions ;
//    }
//
//    private void backtrack(StringBuilder cur,int pos,int length,List<String> compeletions,int open,int close){
//        if(cur.length() == length){
//            compeletions.add(cur.toString()) ;
//        }else {
//           if (open < length){
//               cur.append('(');
//               backtrack(cur,pos+1,length,compeletions,open+1,close);
//               cur.deleteCharAt(cur.length()-1) ;
//           }
//           if (close < open){
//               cur.append(')');
//               backtrack(cur,pos+1,length,compeletions,open,close+1);
//               cur.deleteCharAt(cur.length()-1) ;
//           }
//        }
//    }

    /**
     * 暴力递归法
     */
    private void getParenthesis(int max, int pos, char[] str, List<String> completions) {
        if (pos == 2 * max) {
            completions.add(toString(str));
            return;
        }
        str[pos] = '(';
        getParenthesis(max, pos + 1, str, completions);
        str[pos] = ')';
        getParenthesis(max, pos + 1, str, completions);
    }

    public List<String> generateParenthesis(int n) {
        List<String> completions = new ArrayList<>();
        getParenthesis(n, 0, new char[2 * n], completions);
        return completions.stream()
                .filter(this::valid).collect(Collectors.toList());
    }

    private String toString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }

    private boolean valid(String Str) {
        int balance = 0;
        for (int i = 0; i < Str.length(); i++) {
            if (Str.charAt(i) == '(') {
                balance++;
            }
            if (Str.charAt(i) == ')'){
                balance-- ;
            }
            if (balance < 0){
                return false ;
            }
        }
        return balance == 0 ;
    }

}
