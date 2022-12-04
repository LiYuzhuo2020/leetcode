package com.leetcode.alg;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author: drainli
 **/
public class _682_CalPoints {

    private final static Map<String,String> MAP = new HashMap<>();

    static {
        MAP.put("+","+") ;
        MAP.put("C","C");
        MAP.put("D","D") ;
    }

    public int calPoints(String[] ops) {
        Holder<Integer> ans = new Holder<>() ;
        ans.set(0);
        List<String> pos = new ArrayList<>() ;
        Stream.iterate(0,index -> index + 1).limit(ops.length).forEach(index->{
            operation(MAP.get(ops[index]),pos,ops,index);
        });
        pos.forEach(s->{
            int value = ans.getValue();
            value += Integer.parseInt(s) ;
            ans.set(value);
        });

        return ans.getValue() ;
    }

    private void operation(String op,List<String> ans,String[] ops,int index){
        if (Objects.isNull(op)){
            op = "" ;
        }
        int res = 0 ;
        switch (op){
            case "+":
                res = Integer.parseInt(ans.get(ans.size()-1))+Integer.parseInt(ans.get(ans.size()-2)) ;
                ans.add(String.valueOf(res));
                break;
            case "C":
                ans.remove(ans.size()-1);
                break;
            case "D":
                ans.add(String.valueOf(2 * Integer.parseInt(ans.get(ans.size()-1)))) ;
                break;
            default:
                ans.add(ops[index]) ;
        }
    }

    static class Holder<T>{

        T value ;

        void set(T value){
            this.value = value ;
        }

        T getValue(){
            return this.value ;
        }
    }

    public static void main(String[] args) {
        _682_CalPoints calPoints = new _682_CalPoints() ;
        String[] pos = new String[]{"5","2","C","D","+"} ;
        calPoints.calPoints(pos) ;
    }

}
