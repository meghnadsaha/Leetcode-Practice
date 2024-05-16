package com.interview.sliding.window;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MaxVowelsInSubstring {
    public static int maxVowels ( String s , int k ) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int maxVowelCount = 0;
        int currentVowelCount = 0;
        int left = 0;

        for (int right = 0 ; right < s.length() ; right++) {
            System.out.println(" left: "+left+" right: "+right+" s.charAt("+right+")): "+s.charAt(right)+", Window: "+s.substring(left,right+1));

            if (vowels.contains(s.charAt(right))) {
                currentVowelCount++;
                System.out.println("currentVowelCount25: "+currentVowelCount);
            }

            System.out.println("Check if the window size exceeds k: "+k+" , "+right+" -"+left+" + 1 > "+k+" : "+(right - left + 1 > k));
            if (right - left + 1 > k) {
                if (vowels.contains(s.charAt(left))) {
                    currentVowelCount--;
                }
                left++;
                System.out.println("currentVowelCount30: "+currentVowelCount+" left: "+left);

            }
            System.out.println("maxVowelCount: "+maxVowelCount+" currentVowelCount: "+currentVowelCount+" Math.max("+maxVowelCount+" ,"+ currentVowelCount+"): "+currentVowelCount);

            maxVowelCount = Math.max(maxVowelCount , currentVowelCount);
            System.out.println("maxVowelCount: "+maxVowelCount+"\n");

        }

        return maxVowelCount;
    }

    public static void main ( String[] args ) {
        String s = "abciiidef";
        int k = 3;
        int result = maxVowels(s,3);
        System.out.println();
    }
}
