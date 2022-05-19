package com.interview.random.uber;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    private TwoSum1(){
        throw new IllegalStateException("");
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapping = new HashMap<>();    //Entry: <Number, Index>
        //add all values and indicies to mapping
        for (int index = 0; index < nums.length; index++) {
            mapping.put(nums[index], index);
        }
        //for each item, search the map for the complement.
        //if the complement exists, return current index & compliment's index (from mapping). else continue.
        for (int index = 0; index < nums.length; index++) {
            int compliment = target - nums[index];
            Integer i = mapping.get(compliment);
            if (i != null && !i.equals(index)) {
                return new int[]{index, i};
            }
        }
        return new int[]{};
    }



}
