package com.leetcode.alg;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: drainli
 **/
public class _FindTheWinner_1823 {

    public int findTheWinner(int n, int k) {
        /**基于数组的双向队列**/
        Queue<Integer> queue = new ArrayDeque<Integer>() ;
        for(int i=1;i<=n;i++){
            queue.offer(i) ;
        }
       while (queue.size()>1){
           // 模拟出队
           for(int i=0;i<k-1;i++){
               if (!queue.isEmpty()){
                   int tmp = queue.poll() ;
                   queue.offer(tmp) ;
               }
           }
           queue.poll() ;
       }
       if (queue.size()<=0)
           throw new RuntimeException("queue's size is less than zero!") ;
       return queue.poll() ;
    }
}
