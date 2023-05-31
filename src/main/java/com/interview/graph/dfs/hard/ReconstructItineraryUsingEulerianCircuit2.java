package com.interview.graph.dfs.hard;

import java.util.*;

/**To solve the problem using Eulerian Circuit, we can follow these steps:

 1. Create a graph using the given tickets, where each airport is represented as a node, and the flights between airports are represented as edges.

 2. Sort the destinations (arrival airports) in lexicographic order for each departure airport. This ensures that we visit the smaller destination
 first in case of multiple flights from the same departure airport.

 3. Initialize an empty stack and push the starting airport, "JFK", onto the stack.

 4. While the stack is not empty, do the following:
 - Peek the top airport from the stack.
 - If the airport has any remaining destinations, select the smallest lexicographic destination and push it onto the stack.
 - If the airport has no remaining destinations, pop the airport from the stack and add it to the itinerary list.

 5. Reverse the itinerary list to get the correct order of airports visited.

 6. Return the itinerary list.

 For the given example:

 Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]

 The itinerary using Eulerian Circuit will be:

 1. Create a graph: JFK -> MUC -> LHR -> SFO -> SJC
 2. Sort destinations: JFK -> MUC -> LHR -> SFO -> SJC
 3. Start with JFK, push JFK onto the stack.
 4. Stack: [JFK]
 5. JFK has destinations MUC. Push MUC onto the stack.
 6. Stack: [JFK, MUC]
 7. MUC has destinations LHR. Push LHR onto the stack.
 8. Stack: [JFK, MUC, LHR]
 9. LHR has destinations SFO. Push SFO onto the stack.
 10. Stack: [JFK, MUC, LHR, SFO]
 11. SFO has destination SJC. Push SJC onto the stack.
 12. Stack: [JFK, MUC, LHR, SFO, SJC]
 13. SJC has no remaining destinations. Pop SJC from the stack and add it to the itinerary list.
 14. Stack: [JFK, MUC, LHR, SFO]
 15. SFO has no remaining destinations. Pop SFO from the stack and add it to the itinerary list.
 16. Stack: [JFK, MUC, LHR]
 17. LHR has no remaining destinations. Pop LHR from the stack and add it to the itinerary list.
 18. Stack: [JFK, MUC]
 19. MUC has no remaining destinations. Pop MUC from the stack and add it to the itinerary list.
 20. Stack: [JFK]
 21. JFK has no remaining destinations. Pop JFK from the stack and add it to the itinerary list.
 22. Stack: []

 Reverse the itinerary list: ["JFK","MUC","LHR","SFO","SJC"]

 Return the itinerary list: ["JFK","MUC","LHR","SFO","SJC"]
 */
public class ReconstructItineraryUsingEulerianCircuit2 {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();

        // Step 1: Construct the graph
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            graph.putIfAbsent(departure, new ArrayList<>());
            graph.get(departure).add(arrival);
        }

        // Step 3: Sort the lists of destinations
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }

        Stack<String> stack = new Stack<>();
        List<String> circuit = new ArrayList<>();

        // Step 6: Push the starting airport to the stack
        stack.push("JFK");

        // Step 7: Perform DFS using stack
        while (!stack.isEmpty()) {
            String current = stack.peek();

            // Step 7b: If current airport has no outgoing edges, add it to the circuit
            if (!graph.containsKey(current) || graph.get(current).isEmpty()) {
                circuit.add(stack.pop());
            } else {
                // Step 7c: Push the next unvisited destination to the stack and remove the edge from the graph
                stack.push(graph.get(current).remove(0));
            }
        }

        // Step 8: Reverse the circuit to get the correct order
        Collections.reverse(circuit);

        return circuit;
    }
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

//        tickets.add(Arrays.asList("JFK","SFO"));
//        tickets.add(Arrays.asList("JFK","ATL"));
//        tickets.add(Arrays.asList("SFO","ATL"));
//        tickets.add(Arrays.asList("ATL","JFK"));
//        tickets.add(Arrays.asList("ATL","SFO"));


        ReconstructItineraryUsingEulerianCircuit2 solution = new ReconstructItineraryUsingEulerianCircuit2();
        List<String> itinerary = solution.findItinerary(tickets);
        System.out.println(itinerary);
    }
    /**
     * The time complexity of the given code is O(E log E), where E is the number of edges (flights) in the input tickets list.
     *
     * 1. Building the graph takes O(E log E) time. In the worst case, there can be E log E operations required to insert all the edges into the priority queues. This is because inserting an element into a priority queue takes O(log E) time, and there can be up to E edges in total.
     *
     * 2. The DFS traversal visits each edge (flight) once. In the worst case, each edge is visited once and removed from the priority queue, which takes O(log E) time. Therefore, the overall time complexity of the DFS traversal is O(E log E).
     *
     * 3. Reversing the itinerary using `Collections.reverse` takes O(E) time, as there can be a maximum of E airports in the itinerary.
     *
     * Therefore, the overall time complexity is O(E log E).
     *
     * The space complexity of the given code is O(E), where E is the number of edges (flights) in the input tickets list.
     *
     * 1. The graph variable uses O(E) space to store the flights. Each edge is stored once in the graph.
     *
     * 2. The itinerary variable also uses O(E) space, as it stores the airports in the itinerary, and in the worst case, there can be up to E airports in the itinerary.
     *
     * 3. The recursive DFS call stack uses O(E) space in the worst case, as it keeps track of the visited airports during the DFS traversal.
     *
     * Therefore, the overall space complexity is O(E).
     */
}
