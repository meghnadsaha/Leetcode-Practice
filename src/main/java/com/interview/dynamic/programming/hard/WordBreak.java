package com.interview.dynamic.programming.hard;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class WordBreak {

    public static boolean wordBreakUsing_java8 ( String s , List<String> wordDict ) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        return IntStream.range(1, n + 1)
                        .anyMatch(i -> IntStream.range(0, i)
                                                .anyMatch(j -> dp[j] && wordDict.contains(s.substring(j, i)))
                        );
    }

    public static boolean wordBreak ( String s , List<String> wordDict ) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (dp[j] && wordDict.contains(s.substring(j , i))) {
//                    System.out.println("j "+j+" , i"+i+"  "+s.substring(j , i));
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }


    public static void main ( String[] args ) {
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet" , "code");
        System.out.println(wordBreak(s1 , wordDict1)); // Output: true

//        String s2 = "applepenapple";
//        List<String> wordDict2 = Arrays.asList("apple" , "pen");
//        System.out.println(wordBreak(s2 , wordDict2)); // Output: true
//
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats" , "dog" , "sand" , "and" , "cat");
        System.out.println(wordBreakUsing_java8(s3 , wordDict3)); // Output: false
    }

}
