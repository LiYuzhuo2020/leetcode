package com.leetcode.alg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Author: drainli
 **/
public class _657_TwoSum {

    public boolean findTarget( TreeNode root,int k){
        Queue<TreeNode> queue = new LinkedList<>() ;
        HashSet<Integer> set = new HashSet<>() ;
        TreeNode cur = root ;
        queue.offer(cur) ;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll() ;
            if (set.contains(k - node.val)){
                return true ;
            }else {
                set.add(node.val) ;
            }
            if (!Objects.equals(null,node.right)){
                queue.add(node.right) ;
            }
            if (!Objects.equals(null,node.left)){
                queue.add(node.left) ;
            }
        }

        return false ;
    }

}

class TreeNode {
    int val ;
    TreeNode left ;
    TreeNode right ;

    public TreeNode(){

    }

    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val ;
        this.left = left ;
        this.right = right ;
    }
}
