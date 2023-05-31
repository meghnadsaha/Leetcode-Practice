package com.interview.graph.dfs.hard;

import java.util.*;

/**
 * ইউলেরিয়ান সার্কিট, যা আরও ইউলেরিয়ান ট্যুর বা ইউলেরিয়ান পাথ হিসাবেও পরিচিত, একটি গ্রাফে এমন একটি পথ বোঝায় যা প্রতিটি এজ একবারই দেখে
 * এবং শুরুর নোডে শেষ হয়। অর্থাৎ, এটি সমস্ত এজকে ধারণ করে গ্রাফের সমস্ত এজে যাত্রা করে।
 *
 * ইউলেরিয়ান সার্কিট একটি গ্রাফ যখন দায়িত্ব করে তখন নিম্নলিখিত শর্তাদি পূরণ করতে হয়:
 *
 * 1. সংযুক্ততা: গ্রাফটি সংযুক্ত হতে হবে, অর্থাৎ যেকোনো দুটি নোডের মধ্যে একটি পাথ থাকতে হবে।
 * 2. ডিগ্রি শর্ত: গ্রাফের প্রতিটি নোডের ডিগ্রি জোড় হতে হবে (নোডের সাথে সংযুক্ত এজের সংখ্যা)। নির্দিষ্ট একটি অভিন্ন দিকের গ্রাফের জন্য, প্রতিটি নোডের আগমন
 * এবং সাগরের ডিগ্রি সমান হতে হবে, কেবলমাত্র দুটি নোড বাদে যেখানে একটি নোডের আগমন ডিগ্রি বে
 *
 * শি এক অতিরিক্ত (শুরু নোড) এবং অন্য একটি নোডের আগমন ডিগ্রি এক অতিরিক্ত বেশি (শেষ নোড)।
 *
 * যদি এই শর্তাদি পূরণ করে থাকে, তবে গ্রাফটি একটি ইউলেরিয়ান সার্কিট ধারণ করে। ইউলেরিয়ান সার্কিট খুঁজে পাওয়ার জন্য হায়ারহোলজারের অ্যালগরিদম ব্যবহার করা
 * যায়, যা ডেপথ-ফার্স্ট সার্চের উপর ভিত্তি করে এবং সার্কিটটি পর্যাপ্তভাবে গঠন করে।
 *
 * ইউলেরিয়ান সার্কিটের ব্যবহার নিয়ে বিভিন্ন ক্ষেত্রে অ্যাপ্লিকেশন রয়েছে, যেমন চীনা ডাকীর সমস্যার সমাধান, যেখানে লক্ষ্য হলো একটি গ্রাফে কমপক্ষে একবারই প্রতিটি এজ
 * ধারণ করে সবচেয়ে কম দূরত্বে সম্ভবতঃ যাত্রা করার সহজতম পথ খুঁজা।
 */

public class ReconstructItineraryUsingEulerianCircuit {

    /**
     * In the Java implementation using Eulerian Circuit, a PriorityQueue is used to store the destinations for
     * each departure airport in lexicographic order. The reason for using a PriorityQueue is to ensure that the
     * smallest lexicographic destination is selected first during the depth-first search (DFS) traversal.
     *
     * By using a PriorityQueue, we can automatically retrieve the smallest lexicographic destination from the
     * available destinations for an airport. This helps in maintaining the order of visiting destinations in
     * the itinerary, as required by the problem statement. Without the PriorityQueue, we would have to manually
     * sort the destinations and select the smallest lexicographic destination, which would require extra code
     * and potentially slower performance.
     *
     * The use of PriorityQueue ensures that the itinerary is constructed in the smallest lexical order when read
     * as a single string, as mentioned in the problem statement.
     */
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

        dfs("JFK"); // Start the DFS from "JFK" airport

        Collections.reverse(itinerary); // Reverse the itinerary to get the correct order
        return itinerary;
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll());
        }

        itinerary.add(airport);
    }
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("MUC", "LHR"));
//        tickets.add(Arrays.asList("JFK", "MUC"));
//        tickets.add(Arrays.asList("SFO", "SJC"));
//        tickets.add(Arrays.asList("LHR", "SFO"));

        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));


        ReconstructItineraryUsingEulerianCircuit solution = new ReconstructItineraryUsingEulerianCircuit();
        List<String> itinerary = solution.findItinerary(tickets);
        System.out.println(itinerary);
    }
}
