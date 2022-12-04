package com.leetcode.alg;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: drainli
 **/
public class MedianFinder {

    PriorityQueue<Integer> minUqe;
    PriorityQueue<Integer> maxQue;


    /** initialize your data structure here. */
    public MedianFinder() {
        minUqe = new PriorityQueue<>((a,b) -> b -a ) ;
        maxQue = new PriorityQueue<>(Comparator.comparingInt(a -> a)) ;
    }

    public void addNum(int num) {
        if (minUqe.isEmpty() || num <= minUqe.peek()) {
            minUqe.offer(num);
            if (maxQue.size() + 1 < minUqe.size()) {
                maxQue.offer(minUqe.poll());
            }
        } else {
            maxQue.offer(num);
            if (maxQue.size() > minUqe.size()) {
                minUqe.offer(maxQue.poll());
            }
        }
    }

    public double findMedian() {
        if (minUqe.size() > maxQue.size()) {
            return minUqe.peek();
        }
        return (minUqe.peek() + maxQue.peek()) / 2.0;
    }

}
