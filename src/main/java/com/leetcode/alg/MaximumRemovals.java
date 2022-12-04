package com.leetcode.alg;

import java.util.*;

/**
 * @Author: drainli
 **/
public class MaximumRemovals {

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0,right = removable.length ;
        int ans =  0 ;
        while (left <= right){
            int mid = ((right - left ) >> 1) + left ;
            if (isChildSeries(s,p,mid,removable)){
                // means that k can be larger
                left = mid + 1 ;
                ans = mid ;
            }else {
                // means that the k should be smaller
                right = mid - 1 ;
            }
        }

        return ans ;
    }


    private boolean isChildSeries(String s,String p ,int k,int[] removable){
        int[] remove = new int[k] ;
        for (int i=0;i<k;i++){
            remove[i] = removable[i] ;
        }
        char[] srr = s.toCharArray() ;
        Map<Integer,Character> srrList = new HashMap<>() ;
        for (int i=0;i<srr.length;i++){
            srrList.put(i,srr[i]) ;
        }
        Arrays.stream(remove).forEach(
                srrList::remove
        );
        if (srrList.values().size() < p.length()){
            return  false ;
        }
        char[] prr = p.toCharArray() ;
        Character[] srrChange = srrList.values().toArray(new Character[0]);
        int l = 0 ,r = prr.length-1 ;
        while (r <= srrChange.length-1){
            if (prr[l] != srrChange[l]){
                l++;
                r++;
            }else {
                StringBuilder sbP = new StringBuilder() ;
                StringBuilder sbS = new StringBuilder() ;
                for (int i=0;i<prr.length;i++){
                    sbP.append(String.valueOf(prr[i])) ;
                }
                for (int i=0;i<srrChange.length;i++){
                    sbS.append(srrChange[i]) ;
                }
                // verify whether p string is the subsequence of s string
                if (sbP.length() > sbS.length()){
                    return false ;
                }

                int left = 0,right = 0 ;
                while (left < sbP.length() && right < sbS.length()) {
                    while (sbP.charAt(left) != sbS.charAt(right)) {
                        if (right >= sbS.length()) {
                            return false;
                        }
                        right++;
                    }
                    left++;
                    right++;
                }
               return  true ;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        "abcacb"
//        "ab"
//        [3,1,0]
       String s = "abcacb" ;
       String p = "ab" ;
       int[] removable = {3,1,0} ;
       MaximumRemovals maximumRemovals = new MaximumRemovals() ;
        System.out.println(maximumRemovals.maximumRemovals(s,p,removable)) ;
    }

}
