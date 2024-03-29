package com.leetcode.alg;

/**
 * @Author: drainli
 **/
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.") ;
        String[] v2 = version2.split("\\.") ;
        int i=0,j=0;
        while(i<v1.length && j<v2.length){
            if(i<v1.length && j<v2.length && Integer.parseInt(v1[i]) == Integer.parseInt(v2[j])){
                i++;j++;
            }else if(i<v1.length && j<v2.length && Integer.parseInt(v1[i]) < Integer.parseInt(v2[j])){
                return -1 ;
            }else if(i<v1.length && j<v2.length && Integer.parseInt(v1[i]) > Integer.parseInt(v2[j])){
                return 1 ;
            }
        }
        while(i < v1.length || j < v2.length){
            if (i < v1.length && Integer.parseInt(v1[i]) > 0){
                return 1 ;
            }else if (j<v2.length && Integer.parseInt(v2[j])>0){
                return -1 ;
            }
        }
        i++;
        j++;
        return 0 ;
    }

}
