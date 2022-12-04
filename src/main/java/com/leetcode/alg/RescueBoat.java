package com.leetcode.alg;

import java.util.Arrays;

/**
 * @Author: drainli
 **/
public class RescueBoat {

    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
       int sumBoat = 0 ;
       int i=0,j=people.length - 1 ;
       while (i < j){
           if (people[i]+people[j] <= limit){
               sumBoat += 1 ;
               i++;
               j--;
           }else {
               sumBoat += 1 ;
               j--;
           }
       }
       return sumBoat + 1;
    }

}
