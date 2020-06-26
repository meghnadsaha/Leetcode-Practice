package com.interview.dynamic.programming;

public class RegularExpressionMatching_10 {


	    
	    /**
	     * Dynamic programming technique for regex matching.
	     */
	    public boolean isMatch(String s, String p) {
            char[] text=s.toCharArray();
            char[] pattern =p.toCharArray();
	   // public boolean matchRegex(char[] text, char[] pattern) {
	        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

	        T[0][0] = true;
	        //Deals with patterns like a* or a*b* or a*b*c*
	        for (int i = 1; i < T[0].length; i++) {
	            if (pattern[i-1] == '*') {
	                T[0][i] = T[0][i - 2];
	            }
	        }

	        for (int i = 1; i < T.length; i++) {
	            for (int j = 1; j < T[0].length; j++) {
	                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
	                    T[i][j] = T[i-1][j-1];
	                } else if (pattern[j - 1] == '*')  {
	                    T[i][j] = T[i][j - 2];
	                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
	                        T[i][j] = T[i][j] | T[i - 1][j];
	                    }
	                } else {
	                    T[i][j] = false;
	                }
	            }
	        }
	        return T[text.length][pattern.length];
	    }
	public static void main(String args[]) {
		RegularExpressionMatching_10 rm = new RegularExpressionMatching_10();
		System.out.println(rm.isMatch("Tushar", "Tushar"));
		System.out.println(rm.isMatch("Tusha", "Tushar*a*b*"));
		System.out.println(rm.isMatch("", "a*b*"));
		System.out.println(rm.isMatch("abbbbccc", "a*ab*bbbbc*"));
		System.out.println(rm.isMatch("abbbbccc", "aa*bbb*bbbc*"));
		System.out.println(rm.isMatch("abbbbccc", ".*bcc"));
		System.out.println(rm.isMatch("abbbbccc", ".*bcc*"));
		System.out.println(rm.isMatch("abbbbccc", ".*bcc*"));
		System.out.println(rm.isMatch("aaa", "ab*a*c*a"));
		System.out.println(rm.isMatch("aa", "a*")+"\n");
		
		System.out.println(rm.isMatch("aa", "a"));
		System.out.println(rm.isMatch("ab", ".*"));
		System.out.println(rm.isMatch("aab", "c*a*b"));
		System.out.println(rm.isMatch("mississippi", "mis*is*p*."));
		
		
		
	}
}
