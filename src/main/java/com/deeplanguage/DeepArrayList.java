package com.deeplanguage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: drainli
 **/
public class DeepArrayList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>() ;
        List<Integer> retainList = new ArrayList<>() ;
        list.add(1);
        list.add(2);
        list.add(3);
        retainList.add(2);
        list.retainAll(retainList) ;

        list.forEach(num -> System.out.println(num));
    }

}
