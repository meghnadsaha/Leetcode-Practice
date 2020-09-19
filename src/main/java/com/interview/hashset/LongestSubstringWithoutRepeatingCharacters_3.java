package com.interview.hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class LongestSubstringWithoutRepeatingCharacters_3 {

	public int lengthOfLongestSubstring(String s) {

		if (s.length() == 0 || s == null)
			return 0;

		int low = 0, high = 0, maxLen = 1;
		Set<Character> set = new HashSet<Character>();
		for (; high < s.length(); high++) {
			char cur = s.charAt(high);

			if (!set.add(cur)) {
				while (low < high && s.charAt(low) != cur) { // pwwkew
					set.remove(cur);
					low++;
				}
				low++;
			}
			maxLen = Math.max(maxLen, high - low + 1);
		}

		return maxLen;

	}

	public int lengthOfLongestSubstring2(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				// last repeated character's pos + 1, we pick the max otherwise,
				// the last character could repeat again.
				j = Math.max(j, map.get(s.charAt(i)) + 1);
				// If the character is already in the hashmap, then move the
				// left pointer to the right of the same character last found.
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}
