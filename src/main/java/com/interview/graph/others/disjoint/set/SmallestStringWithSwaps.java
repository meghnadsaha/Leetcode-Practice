package com.interview.graph.others.disjoint.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestStringWithSwaps {


    final static int N = 100001;
    static boolean[] visited = new boolean[N];
    static List<Integer>[] adj = new ArrayList[N];

    private static void DFS(String s, int vertex, List<Character> characters, List<Integer> indices) {
        characters.add(s.charAt(vertex));
        indices.add(vertex);

        visited[vertex] = true;

        for (int adjacent : adj[vertex]) {
            if (!visited[adjacent]) {
                DFS(s, adjacent, characters, indices);
            }
        }
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        for (int i = 0; i < s.length(); i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);

            adj[source].add(destination);
            adj[destination].add(source);
        }


        char[] answer = new char[s.length()];
        for (int vertex = 0; vertex < s.length(); vertex++) {
            if (!visited[vertex]) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();

                DFS(s, vertex, characters, indices);

                Collections.sort(characters);
                Collections.sort(indices);

                for (int index = 0; index < characters.size(); index++) {
                    answer[indices.get(index)] = characters.get(index);
                }

            }
        }
        return String.valueOf(answer);
    }


    public static void main(String[] args) {
//        String s = "dcab";
//        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2));

        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2));


        System.out.println(smallestStringWithSwaps(s, pairs));

    }


}