package com.leetcode.alg;

/**
 * @Author: drainli
 **/
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int maxLength = 1 , begin = 0 ,n = s.length();
        boolean[][] dp = new boolean[n][n] ;
        for(int i=0;i<n;i++){
            dp[i][i] = true ;
        }
        // 分别校验不同的长度的字符串是否为回文字符串
        char[] arr = s.toCharArray() ;
        for(int L =2;L<=n;L++){
            for(int i=0;i<n-1;i++){
                int j = L + i - 1 ;
                if(j >= n){
                    break;
                }
                if( arr[i] != arr[j] ){
                    dp[i][j] = false ;
                }else{
                    if (j-i<3){
                        dp[i][j] = true ;
                    }else {
                        dp[i][j] = dp[i+1][j-1] ;
                    }
                }
                if (dp[i][j] && j-i+1>maxLength){
                    maxLength = j-i+1 ;
                    begin = i ;
                }
            }
        }

        return s.substring(begin,begin+maxLength) ;
    }

    public static void main(String[] args) {
        String s = "cbbd" ;
        LongestPalindrome longestPalindrome = new LongestPalindrome() ;
        System.out.println(longestPalindrome.longestPalindrome(s)) ;
    }

}
