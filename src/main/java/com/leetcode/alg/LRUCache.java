package com.leetcode.alg;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: drainli
 **/
class LRUCache {

    private LinkedList<Integer> cache = new LinkedList<>();
    private int capacity ;

    public LRUCache(int capacity) {
        capacity = capacity ;
    }

    public int get(int key) {
        return (cache.get(key) != null ? cache.get(key) : -1) ;
    }

    public void put(int key, int value) {
        if(cache.size() == capacity && cache.get(key) == null){
            // remove the most unused element
            cache.removeLast() ;
        }
        if(cache.get(key) != null){
            return ;
        }

        cache.addFirst(value) ;
    }
}
