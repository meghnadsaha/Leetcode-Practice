package com.interview.sliding.window.medium;

import java.util.*;

public class MinConsecutiveCards {
    public static int minimumCardPickupTimeLimitExceeded ( int[] cards ) {
        int minLength = Integer.MAX_VALUE;
        int n = cards.length;

        for (int i = 0 ; i < n ; i++) {
            for (int j = i + 1 ; j < n ; j++) {
                if (cards[i] == cards[j]) {
                    int length = j - i + 1;
                    minLength = Math.min(length , minLength);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE?-1:minLength;
    }

    public static void main ( String[] args ) {
        MinConsecutiveCards solution = new MinConsecutiveCards();
        int[] cards = {77 , 10 , 11 , 51 , 69 , 83 , 33 , 94 , 0 , 42 , 86 , 41 , 65 , 40 , 72 , 8 , 53 , 31 , 43 , 22 , 9 , 94 , 45 , 80 , 40 , 0 , 84 , 34 , 76 , 28 , 7 , 79 , 80 , 93 , 20 , 82 , 36 , 74 , 82 , 89 , 74 , 77 , 27 , 54 , 44 , 93 , 98 , 44 , 39 , 74 , 36 , 9 , 22 , 57 , 70 , 98 , 19 , 68 , 33 , 68 , 49 , 86 , 20 , 50 , 43};
        System.out.println(solution.minimumCardPickup(cards));  // Output: 3
    }

    private static int minimumCardPickup ( int[] cards ) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int n = cards.length;

        for (int i = 0 ; i < n ; i++) {

            if (lastIndex.containsKey(cards[i])) {
                // which represents the distance between the current index i and the last index where the card value cards[i] was seen, plus one to include both indices in the count.
                int length = i - lastIndex.get(cards[i]) + 1;
                minLength = Math.min(length , minLength);
                if (minLength == 2) { // Optimization: If minLength becomes 2, no need to check further
                    break;
                }
            }
            lastIndex.put(cards[i] , i);
        }
        return minLength == Integer.MAX_VALUE?-1:minLength;
    }
}
