package com.leetcode.alg;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: drainli
 **/
public class ConvertZ {

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int t = 2*(numRows-1) ;
        char[] arr = s.toCharArray() ;
        int length = arr.length ;
        int cols = (numRows-1)*(length / t) ;
        if(length % t != 0){
            cols+=1 ;
        }
        StringBuilder sb = new StringBuilder() ;
        char[][] matrix = new char[numRows][cols] ;
        for (int i=0;i<numRows;i++){
            Arrays.fill(matrix[i],'0');
        }
        int row = 0,col = 0 ,cur = 0;
        while(col<cols && cur < length){
            if(row == numRows){
                row = numRows-1 ;
                while(row>0){
                    matrix[--row][++col] = arr[cur++] ;
                }
                row++ ;
            }
            if (cur >= length-1){
                break;
            }
            matrix[row++][col] = arr[cur++];
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<cols;j++){
                sb.append(String.valueOf(matrix[i][j]));
            }
        }
        return sb.toString().replaceAll("0","") ;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10,
                0,
                TimeUnit.MICROSECONDS,
                    new ArrayBlockingQueue<>(3)
                );

        for (int i=0;i<10;i++){
            executor.submit(new Job()) ;
        }
        executor.shutdown();
    }

}

class Job implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print( "data ");
    }
}
