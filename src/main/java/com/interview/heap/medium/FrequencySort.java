package com.interview.heap.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> counts = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        counts.addAll(freq.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!counts.isEmpty()) {
            Map.Entry<Character, Integer> element = counts.remove();
            for (int i = 0; i < element.getValue(); i++) {
                sb.append(element.getKey());
            }
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        frequencySort("tree");
    }
}