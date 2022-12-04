package com.leetcode.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: drainli
 **/
public class Subset {

    List<List<Integer>> result = new ArrayList<>() ;
    List<Integer> tmp = new ArrayList<>() ;

    public List<List<Integer>> subset(int[] nums){
        dfs(0,nums);

        return result ;
    }

    private void dfs(int cur , int[] nums){
        // 通过递归搜索算法来做迭代一般是先加再减
        if(cur == nums.length){
            result.add(new ArrayList<>(tmp)) ;
            return;
        }

        tmp.add(nums[cur]) ;
        dfs(cur+1,nums);
        tmp.remove(tmp.size()-1) ;
        dfs(cur+1,nums);
    }

}
