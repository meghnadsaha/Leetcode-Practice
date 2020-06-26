package com.interview.string;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		HashMap<Integer, Character[]> map = new HashMap<Integer, Character[]>();
		map.put(2, new Character[] { 'a', 'b', 'c' });
		map.put(3, new Character[] { 'd', 'e', 'f' });
		map.put(4, new Character[] { 'g', 'h', 'i' });
		map.put(5, new Character[] { 'j', 'k', 'l' });
		map.put(6, new Character[] { 'm', 'n', 'o' });
		map.put(7, new Character[] { 'p', 'q', 'r', 's' });
		map.put(8, new Character[] { 't', 'u', 'v' });
		map.put(9, new Character[] { 'w', 'x', 'y', 'z' });

		List<String> returnList = new LinkedList<String>();
		combHelper(0, map, returnList, digits, "");
		return returnList;

	}

	public void combHelper(int start, Map map, List returnList, String string, String temp) {

		if (start > string.length() - 1)
			return;

		int curr = Character.getNumericValue(string.charAt(start));

		for (Character element : (Character[]) map.get(curr)) {
			combHelper(start + 1, map, returnList, string, temp + element);
			if (start == string.length() - 1)
				returnList.add(temp + element);
		}

	}

}
