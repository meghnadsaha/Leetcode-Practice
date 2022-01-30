package com.interview.string;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
	public static List<String> letterCombinations2(String digits) {
		HashMap<Integer, Character[]> map = new HashMap<>();
		map.put(2, new Character[] { 'a', 'b', 'c' });
		map.put(3, new Character[] { 'd', 'e', 'f' });
		map.put(4, new Character[] { 'g', 'h', 'i' });
		map.put(5, new Character[] { 'j', 'k', 'l' });
		map.put(6, new Character[] { 'm', 'n', 'o' });
		map.put(7, new Character[] { 'p', 'q', 'r', 's' });
		map.put(8, new Character[] { 't', 'u', 'v' });
		map.put(9, new Character[] { 'w', 'x', 'y', 'z' });

		List<String> returnList = new LinkedList<>();
		combHelper(0, map, returnList, digits, "");
		return returnList;

	}

	public static void combHelper(int start, Map<Integer, Character[]> map, List<String> returnList, String string, String temp) {

		if (start > string.length() - 1)
			return;

		int curr = Character.getNumericValue(string.charAt(start));

		for (Character element :  map.get(curr)) {
			combHelper(start + 1, map, returnList, string, temp + element);
			if (start == string.length() - 1)
				returnList.add(temp + element);
		}

	}


	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}

	public static void main(String[] args){
		System.out.println(letterCombinations2("29"));
	}


}
