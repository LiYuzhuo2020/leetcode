package com.leetcode.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: drainli
 **/
public class Permute {


    /**
     *  方法一
     * @param args
     */
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>() ;
//        int n = nums.length ;
//        int[] a = new int[n] ;
//        for (int i=0;i<n;i++){
//            a[i] = i ;
//        }
//        int rows = 1 ;
//        for (int i=1;i<=n;i++){
//            rows *= i ;
//        }
//        int[][] arr = new int[rows][n] ;
//        AtomicInteger index = new AtomicInteger(0) ;
//        int[][] res = Permutation(0,n,a,arr,index);
//        for (int row=0;row<res.length;row++){
//            List<Integer> tmp = new ArrayList<>() ;
//            for (int col=0;col<n;col++){
//                tmp.add(nums[res[row][col]]) ;
//            }
//            ans.add(tmp) ;
//        }
//        return ans ;
//    }
//
//    int[][] Permutation(int m, int n, int a[],int[][] ans,AtomicInteger index) {
//
//        int i, temp;
//        //递归到底层
//        if (m == n - 1) {
//            int[] arr = new int[n] ;
//            for (i = 0; i < n ; i++)
//                arr[i] = a[i] ;
//            ans[index.getAndIncrement()] = arr ;
//        } else {
//            for (i = m; i < n; i++) {
//                temp = a[m];
//                a[m] = a[i];
//                a[i] = temp;
//                //递归到下一层
//                Permutation(m + 1, n, a,ans,index);
//                //保证递归后保持上一层的顺序
//                temp = a[m];
//                a[m] = a[i];
//                a[i] = temp;
//            }
//        }
//
//        return ans ;
//    }

    /**
     *  方法二
     * @param args
     */
    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            // 3、不用拷贝，因为每一层传递下来的 path 变量都是新建的
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 1、每一次尝试都创建新的变量表示当前的"状态"
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);
                newUsed[i] = true;

                dfs(nums, len, depth + 1, newPath, newUsed, res);
                // 2、无需回溯
            }
        }
    }

    public static void main(String... args) {
        Permute permute = new Permute() ;
        permute.permute(new int[]{1,2,3,4}) ;
    }

}
