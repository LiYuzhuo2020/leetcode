package com.leetcode.offer;

/**
 * @Author: drainli
 **/
public class Test {

    public static void main(String[] args) {
        Child c = new Child() ;
        Parent p = (Parent) c;
        p.method();
        // call the static method
        p.smethod() ; // similar to
    }

}
