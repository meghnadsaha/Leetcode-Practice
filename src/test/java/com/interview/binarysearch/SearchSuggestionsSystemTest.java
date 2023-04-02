package com.interview.binarysearch;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystemTest {

    SearchSuggestionsSystem obj = new SearchSuggestionsSystem();

    @Test
    public void testSuggestedProducts() {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> actual = obj.suggestedProducts(products, searchWord);
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("mobile", "moneypot", "monitor"),
                Arrays.asList("mobile", "moneypot", "monitor"),
                Arrays.asList("mouse", "mousepad"),
                Arrays.asList("mouse", "mousepad"),
                Arrays.asList("mouse", "mousepad")
        );
        System.out.println("expected : ");
        print(expected);
        System.out.println("actual   : ");
        print(actual);

    }

    public void print(List<List<String>> ls) {
        for (List<String> innerLs : ls) {
            Object[] arr = innerLs.toArray();
            System.out.println(Arrays.deepToString(arr));
        }
    }
}