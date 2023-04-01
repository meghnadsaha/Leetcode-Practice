package com.interview.bruteforce.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroupAnagramsTest  {

    GroupAnagrams obj = new GroupAnagrams();
    @Test
    public void testGroupAnagrams() {
        List<List<String>> actual = obj.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat","tan"),
                Arrays.asList("ate","eat","tea")
        );

        assertEquals(expected,actual);
    }
}