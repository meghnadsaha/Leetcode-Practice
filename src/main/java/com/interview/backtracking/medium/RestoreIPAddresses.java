package com.interview.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {


    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        // if the length of the string is longer than 12 which can not form a valid IP
        if (s.length() > 12 || s.length() == 0)
            return addresses;
        backtracking(addresses, new ArrayList<String>(), s, 0);
        return addresses;
    }

    private void backtracking(List<String> addresses, List<String> temp, String s, int start) {
        // once reach to end of the string and the have four num inside the list
        // then join these four nums and add to result list
        if (start == s.length() && temp.size() == 4) {
            addresses.add(String.join(".", temp));
            return;
        }

        // each number is between 0 and 255
        // which is 1 digit to 3 digit
        // so we have three different choices for each number
        // 1. substring from start to start+1
        // 2. substring from start to start+2
        // 3. substring from start to start+3
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length())
                return;
            String address = s.substring(start, start + i);
          //  System.out.println("address, substring from start: " + start + " to start+1 : " + (start + i) + " is : " + address);
            // check the address validation
            if (validAddress(address)) {
                // add valid num into List
                // start a new backtracking
                temp.add(address);
            //    System.out.println("temp : " + temp);
                backtracking(addresses, temp, s, start + i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // To valid the given address
    // each integer is between 0 and 255 and can not start with 0
    private boolean validAddress(String address) {
        return !((address.charAt(0) == '0' && address.length() > 1) || Integer.parseInt(address) > 255);
    }
}