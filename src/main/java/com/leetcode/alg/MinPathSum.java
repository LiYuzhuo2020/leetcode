package com.leetcode.alg;

/**
 * @Author: drainli
 **/
public class MinPathSum {

    int[][] dir = new int[][]{{0,1},{1,0}} ;
    int[][] vis ;
    int[][] sv ; // save the specified point' minimum sum

    public int minPathSum(int[][] grid) {
        // I can use the greedy algorithm to do this
        int m = grid.length ;
        int n = grid[0].length ;
        sv = new int[m][n] ;
        vis = new int[m][n] ;
        return dfs(0,0,grid) ;

    }

    private int dfs( int x,int y,int[][] grid){

        int m = grid.length ;
        int n = grid[0].length ;
        int sum = 0 ;

        if(x==m-1 || y==n-1){
          return grid[m-1][n-1] ;
        }

        if (x >= m || y >= n ){
            return Integer.MAX_VALUE ;
        }

        if (sv[x][y] != 0){
            return sv[x][y] ;
        }

        // begin to calculate the sum
        int pathSumL = dfs(x+1,y,grid) ;
        int pathSumR = dfs(x,y+1,grid) ;

        sum = Math.min(pathSumL,pathSumR) + grid[x][y] ;

        vis[x][y] = 0 ;

        return sv[x][y] = sum ;
    }

}
