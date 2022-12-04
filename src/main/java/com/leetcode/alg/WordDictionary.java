package com.leetcode.alg;

import java.util.TreeMap;

/**
 * @Author: drainli
 **/
class WordDictionary {

    private class Node {
        private TreeMap<Character,Node> next ;
        private boolean isWord ;

        public Node(boolean isWord){
            this.isWord = isWord ;
            next = new TreeMap<Character,Node>() ;
        }

        public Node(){
            this(false) ;
        }
    }

    private Node root ;
    private int size ;

    public int getSize(){
        return this.size ;
    }

    public WordDictionary() {
        root = new Node() ;
        size = 0 ;
    }

    public void addWord(String word) {
        Node cur = root ;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i) ;
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node()) ;
            }

            cur = cur.next.get(c) ;
        }

        cur.isWord = true ;
    }

    public boolean search(String word) {
        return match(root,word,0) ;
    }

    private boolean match(Node node,String word , int index){
        // Node cur = node ;
        if(index == word.length()){
            return node.isWord ;
        }
        Character c = word.charAt(index) ;
        if('.'!= c){
            // is not the pattern string
            if(node.next.get(c) == null ){
                return false ;
            }

            return match(node.next.get(c) ,word,index+1) ;
        }else {
            for(char nextChar: node.next.keySet())
                if(match(node.next.get(nextChar), word, index + 1))
                    return true;
            return false;

        }

    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));// 返回 False
        System.out.println(wordDictionary.search("bad"));; // 返回 True
        System.out.println(wordDictionary.search(".ad"));; // 返回 True
        System.out.println(wordDictionary.search("b.."));; // 返回 True
    }
}
