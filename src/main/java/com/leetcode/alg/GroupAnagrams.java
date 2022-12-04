package com.leetcode.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: drainli
 **/
public class GroupAnagrams {

      public List<List<String>> groupAnagrams(String[] strs){
          return new ArrayList<>(Arrays.stream(strs)
                  .collect(Collectors.groupingBy(str -> {
                      // 返回 str 排序后的结果。
                      // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                      char[] array = str.toCharArray();
                      Arrays.sort(array);
                      return new String(array);
                  })).values());
      }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams() ;
        String[] strs = new String[]{"a","ab","abc","cab"} ;
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        lists.stream().forEach(
                list -> {
                    list.stream().forEach(str -> System.out.print(str+" "));
                }
        );

        int i =0 ;

    }
}
