package com.leetcode.alg;

/**
 * @Author: drainli
 **/
public class NumberOfBoomerangs {

    /**
     *  notes:1：计算每一个点与其他的点的距离，如果出现有距离相等的情况，那么就说明组成了一个回旋镖
     *  2：用一个哈希表分别去保存距离并且计算交换位置之后的回旋镖的个数总和
     *  3:由于每一个点都可能和其他的点组成回旋镖并且距离可能会和之前的点的距离相等，
     *  故最外层每循环一次都应该计算一次总的回旋镖的个数
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        return 0 ;
    }

}
