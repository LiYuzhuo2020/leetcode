package com.leetcode.alg;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class RotateMetrics {

    public void rotate(int[][] matrix) {
        int rows = matrix.length ;
        int cols = matrix[0].length ;
        int[][] aux = new int[rows][cols] ;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                aux[j][rows-i-1] = matrix[i][j];
            }
        }

        matrix = aux ;
        int i=0 ;
    }

    public static void main(String[] args) {
        RotateMetrics metrics = new RotateMetrics();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        metrics.rotate(matrix);

        int rows = matrix.length ;
        int cols = matrix[0].length ;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[j][rows-i-1] = matrix[i][j];
            }
        }
    }
}
