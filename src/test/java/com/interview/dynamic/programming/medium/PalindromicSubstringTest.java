package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;

public class PalindromicSubstringTest {

    @Test
    public void testlongestPalindrome0() {

        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();

        int actual = palindromicSubstring.countSubstrings("abc");
        int expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testlongestPalindrome1() {

        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();

        int actual = palindromicSubstring.countSubstrings("aaa");
        int expected = 6;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testlongestPalindrome2() {

        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();

        int actual = palindromicSubstring.countSubstrings("abaab");
        int expected = 8;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testlongestPalindrome4() {

        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();

        int actual = palindromicSubstring.countSubstrings("abbaeae");
        int expected = 11;//"bb" , "abba" ,"aea","eae"

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testlongestPalindrome3() {

        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();

        int actual = palindromicSubstring.countSubstrings("abaaa");
        int expected = 9;

        Assert.assertEquals(expected, actual);
    }


}
