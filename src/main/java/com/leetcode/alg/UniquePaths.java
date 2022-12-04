package com.leetcode.alg;

/**
 * @Author: drainli
 **/
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n] ;
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] ;
            }
        }

        return dp[m-1][n-1] ;
    }

    // way 2

    public int dfs(int x,int y,int m,int n){
        //  right and down directions
        int sum = 0 ;
        int[][] dir = new int[][]{{1,0},{0,1}} ;
        int[][] sv = new int[m][n] ;
        int[][] vis = new int[m][n] ;
        vis[x][y] = 1 ;
        for (int i=0;i<2;i++){
            int tx = x + dir[i][0] ;
            int ty = y + dir[1][i] ;
            if ((tx < m) && (ty < n) && vis[tx][ty] != 1 ){
                if (sv[tx][ty] != 0){
                    sum+=sv[tx][ty] ;
                }else {
                    sum += dfs(tx,ty,m,n) ;
                }
            }
        }
        vis[x][y] = 0 ;
        return sv[x][y] = sum ;
    }

}
