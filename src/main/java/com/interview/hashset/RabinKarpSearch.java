package com.interview.hashset;

public class RabinKarpSearch {

	private int prime = 101;

	public int patternSearch(char[] text, char[] pattern) {
		int m = pattern.length;
		int n = text.length;
		long patternHash = createHash(pattern, m - 1);
		long textHash = createHash(text, m - 1);
		for (int i = 1; i <= n - m + 1; i++) {
			if (patternHash == textHash && checkEqual(text, i - 1, i + m - 2, pattern, 0, m - 1)) {
				return i - 1;// Match Found
			}
			if (i < n - m + 1) {
				textHash = recalculateHash(text, i - 1, i + m - 1, textHash, m);
			}
		}
		return -1;// Not found any matches
	}

	private long recalculateHash(char[] text, int oldIndex, int newIndex, long oldHash, int patternLength) {
		long newHash = oldHash - text[oldIndex];
		newHash = newHash  / prime;
		newHash += text[newIndex] * Math.pow(prime, patternLength - 1);
		return newHash;
	}

	private long createHash(char[] pattern, int end) {
		long hash = 0;
		for (int i = 0; i <= end; i++) {
			hash += pattern[i] * Math.pow(prime, i);
		}
		return hash;
	}

	private boolean checkEqual(char[] text, int start1, int end1, char[] pattern, int start2, int end2) {
		if (end1 - start1 != end2 - start2) {
			return false;
		}
		while (start1 <= end1 && start2 <= end2) {
			if (text[start1] != pattern[start2]) {
				return false;
			}
			start1++;
			start2++;
		}
		return true;
	}

	public static void main(String args[]) {
		RabinKarpSearch rks = new RabinKarpSearch();
		System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "sharRoy".toCharArray()));
		System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "Roy".toCharArray()));
		System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "shas".toCharArray()));
		System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "usha".toCharArray()));
		System.out.println(rks.patternSearch("TusharRoy".toCharArray(), "Tus".toCharArray()));
	}
}
