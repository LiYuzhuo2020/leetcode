package com.leetcode.alg;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: drainli
 *
 * leetcode 804
 **/
public class _804_solution {

    private final static String[] MORSE = new String[]{
            ".-","-...","-.-.","-..",".","..-.","--."
            ,"....","..",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-."
            ,"...","-","..-","...-"
            ,".--","-..-","-.--","--.."
    } ;

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> TRANS_WORDS = new HashSet<>() ;
        for (String word : words){
            StringBuilder sb = new StringBuilder() ;
            for (int i=0;i<word.length();i++){
                sb.append(MORSE[word.charAt(i)-'a']);
            }
            TRANS_WORDS.add(sb.toString());
        }

        return TRANS_WORDS.size() ;
    }

    public static void main(String[] args) {

    }

}
