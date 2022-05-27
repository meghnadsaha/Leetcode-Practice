package com.interview.random.uber;

import java.util.*;

public class ReconstructItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {
            List<String> waypoint = tickets.get(i);
            if (!map.containsKey(waypoint.get(0))) {
                map.put(waypoint.get(0), new PriorityQueue<>());
            }

            map.get(waypoint.get(0)).add(waypoint.get(1));

            if (!map.containsKey(waypoint.get(1))) {
                map.put(waypoint.get(1), new PriorityQueue<>());
            }


        }
        List<String> result = new ArrayList<>();
        dfs(map, result, "JFK");

        Collections.reverse(result);
        return result;
    }

    public static void dfs(Map<String, PriorityQueue<String>> map, List<String> result, String current) {
        PriorityQueue<String> curPQ = map.get(current);
        while (!curPQ.isEmpty()) {
            String nextAirport = curPQ.poll();
            dfs(map, result, nextAirport);
        }
        result.add(current);
    }

    public static void main(String[] args) {
        List<List<String>> board = Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"));
        List<String> output = findItinerary(board);

        output.stream().forEach(p -> System.out.println(p));
    }

}


