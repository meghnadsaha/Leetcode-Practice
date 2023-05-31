package com.interview.backtracking.hard;


import java.util.*;

public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> graph;
    List<String> itinerary;

    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        itinerary = new ArrayList<>();

        // Build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }

        backtrack("JFK"); // Start the backtracking from "JFK" airport

        return itinerary;
    }

    private void backtrack(String airport) {
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
            String nextAirport = graph.get(airport).poll();
            backtrack(nextAirport);
        }

        itinerary.add(0, airport);
    }
    /**
     * You can use the findItinerary method to find the itinerary for a given list of tickets
     *  using backtracking.
     *
     * The input is a list of lists, where each inner list contains the
     * departure airport and arrival airport of a ticket.
     *
     * The output is a list of strings representing the itinerary.
     */


        public static void main(String[] args) {
            List<List<String>> tickets = new ArrayList<>();
            tickets.add(Arrays.asList("MUC", "LHR"));
            tickets.add(Arrays.asList("JFK", "MUC"));
            tickets.add(Arrays.asList("SFO", "SJC"));
            tickets.add(Arrays.asList("LHR", "SFO"));

            ReconstructItinerary solution = new ReconstructItinerary();
            List<String> itinerary = solution.findItinerary(tickets);
            System.out.println(itinerary);

    }

}
