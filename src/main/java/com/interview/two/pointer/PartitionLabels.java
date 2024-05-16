package com.interview.two.pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels ( String s ) {
        Map<Character, Integer> map = new HashMap<>();
        // filling impact of character's
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            map.put(ch , i);
        }
        // making of result
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            max = Math.max(max , map.get(ch));
            if (max == i) {
                // partition time
                res.add(max - prev);
                prev = max;
            }
        }
        return res;
    }

    public static void main ( String[] args ) {
        String s = "eccbbbbdec";
        PartitionLabels p = new PartitionLabels();
        List<Integer> result = p.partitionLabels(s);
        System.out.println(result);
    }

}
