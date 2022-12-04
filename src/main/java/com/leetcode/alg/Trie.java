package com.leetcode.alg;

import java.util.TreeMap;

/**
 * @Author: drainli
 **/
class Trie {

    private Node root ;
    private int size ;

    private static class Node {

        private TreeMap<Character,Node> next ;
        private boolean isWorld ;

        public Node(){
            next = new TreeMap<>() ;
            isWorld = false ;
        }

    }

    public Trie() {
        root = new Node() ;
        size = 0 ;
    }

    public void insert(String word) {

        Node cur = root ;

        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i) ;
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node()) ;
            }
            cur = cur.next.get(c) ;

        }

        if(!cur.isWorld){
            cur.isWorld = true ;
            this.size++ ;
        }

    }

    public boolean search(String word) {
        Node cur = root ;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i) ;
            if (cur.next.get(c) == null){
                return false ;
            }
            cur = cur.next.get(c) ;
        }
        return cur.isWorld ;
    }

    public boolean startsWith(String prefix) {
        Node cur = root ;
        for(int i=0;i<prefix.length();i++ ){
            Character c = prefix.charAt(i) ;
            if(cur.next.get(c) == null){
                return false ;
            }
            cur = cur.next.get(c) ;
        }

        return true ;
    }

    // for testing whether the given world
    //is matching any of the word in the Trie structure .

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
        Node root = new Node() ;
        Node cur = root ;
        cur.next.put('1',new Node()) ;
        cur.next.put('2',new Node()) ;
        cur = cur.next.get('1') ;

        int i=0 ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
