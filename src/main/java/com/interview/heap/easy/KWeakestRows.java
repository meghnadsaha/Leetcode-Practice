package com.interview.heap.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((o1, o2) -> !o1.getValue().equals(o2.getValue()) ? o1.getValue() - o2.getValue() : o1.getKey() - o2.getKey());
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return !o1.getValue().equals(o2.getValue()) ? o1.getValue() - o2.getValue() : o1.getKey() - o2.getKey();
//            }
//        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int start = getStart(mat[i]);
            map.put(i, start);
        }
        pq.addAll(map.entrySet());
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    private int getStart(int[] mat) {
        int start = 0;
        int end = mat.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mat[mid] == 1) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
