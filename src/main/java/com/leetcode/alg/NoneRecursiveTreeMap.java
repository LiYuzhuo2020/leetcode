package com.leetcode.alg;

import java.util.Stack;

/**
 * @Author: drainli
 **/
public class NoneRecursiveTreeMap {

    private class Node {
        int value ;
        Node left ,right ;

        public Node(int data){
            this.value = data ;
        }

    }

    public void nonePreOrder(Node node){
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>() ;
        Node pre = node ;
        stack.push(pre) ;
        while (!stack.isEmpty()){
            System.out.print(stack.pop().value+" ");
            if (pre.right != null){
                stack.push(pre.right) ;
            }
            if (pre.left != null){
                stack.push(pre.left) ;
            }
        }
    }

    private static void inOrderNoRecur(Node node){
       if (node == null){
           return;
       }
       Stack<Node> stack = new Stack<>() ;
       Node pre = node ;
       while (pre != null || !stack.isEmpty()){
            if (pre.left != null){
                stack.push(pre.left);
                pre = pre.left ;
            }else {
                 pre = stack.pop() ;
                System.out.print(pre.value+" ");
                if (pre.right != null){
                    stack.push(pre.right);
                    pre = pre.right ;
                }
            }
       }
        System.out.println();
    }

    private static void postOrderNoRecur(Node node){
        if (node != null){
            Stack<Node> stack = new Stack<>() ;
            while (node != null || !stack.isEmpty()){
                if (node.left != null){
                    stack.push(node.left) ;
                    node = node.left ;
                }else {
                    node = stack.pop() ;
                    if (node.right != null){
                        System.out.print(node.value + " ");
                        stack.push(node.right) ;
                        node = node.right ;
                    }else {
                        System.out.print(node.value+" ");
                    }
                }
            }
        }
    }

}
