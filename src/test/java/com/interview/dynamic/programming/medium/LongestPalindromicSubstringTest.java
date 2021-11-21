package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void testlongestPalindrome0() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("babcbabcbaccba");
        String expected = "abcbabcba";

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testlongestPalindrome1() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("abaaba");
        String expected = "abaaba";

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testlongestPalindrome2() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("abababa");
        String expected = "abababa";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testlongestPalindrome3() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("abcbabcbabcba");
        String expected = "abcbabcbabcba";

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testlongestPalindrome4() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("forgeeksskeegfor");
        String expected = "geeksskeeg";

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testlongestPalindrome5() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("caba");
        String expected = "aba";

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testlongestPalindrome6() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("abacdfgdcaba");
        String expected = "aba";

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testlongestPalindrome7() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("abacdfgdcabba");
        String expected = "abba";

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testlongestPalindrome8() {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String actual = longestPalindromicSubstring.longestPalindrome("abacdedcaba");
        String expected = "abacdedcaba";

        Assert.assertEquals(expected, actual);
    }

}
