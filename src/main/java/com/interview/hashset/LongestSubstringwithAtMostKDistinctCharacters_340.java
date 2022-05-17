package com.interview.hashset;
import java.util.*;

public class LongestSubstringwithAtMostKDistinctCharacters_340 {
	/**
	 * Given a string, find the length of the longest substring T that contains
	 * at most k distinct characters.For example,
	 * 
	 * Given s = eceba and k = 2, T is "ece" which its length is 3
	 * Given s = aa and k = 1, T is "aa" which its length is 2
	 * 
	 * https://www.youtube.com/watch?v=KqXKT-QlCwY&list=PLxhNaYPwn9T62fCzMYo0o85xRr9V4tlXI&index=53
	 * 
	 */

	public int lengthOfLongestSubstringKDistinct(String s, int k) {

		if (s.length() == 0 || s == null) return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int low =0 ;
		int high  =0;
		int maxLen = 0;
		
		for (; high < s.length(); high++) {
			char c = s.charAt(high);
			map.put(c, map.getOrDefault(c, 0)+1);
			
			while (map.size() > k) {
				if(low <= high && map.get(s.charAt(low)) > 0){
					map.put(s.charAt(low), map.get(s.charAt(low))-1);
				}
				if(map.get(s.charAt(low))==0){
					map.remove(s.charAt(low));
				}
				low++;
			}
			maxLen = Math.max(maxLen, high -  low  +1);
		}
		
		
		return maxLen;

	}
}












