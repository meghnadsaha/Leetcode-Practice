package com.interview.backtracking.medium;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class RestoreIPAddressesTest {


    RestoreIPAddresses obj = new RestoreIPAddresses();

    @Test
    public void restoreIpAddressesTest() {

        List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
        System.out.println("Expected Output : "+expected);

        List<String> actual = obj.restoreIpAddresses("25525511135");
        //255 255 111 35
        System.out.println("Actual Output   : "+actual);
    }

    @Test
    public void restoreIpAddressesTestTwo() {

        List<String> expected = Arrays.asList("0.0.0.0");
        System.out.println("Expected Output : "+expected);

        List<String> actual = obj.restoreIpAddresses("0000");

        System.out.println("Actual Output   : "+actual);
    }


    @Test
    public void restoreIpAddressesTestThree() {

        List<String> expected = Arrays.asList("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3");
        System.out.println("Expected Output : "+expected);

        List<String> actual = obj.restoreIpAddresses("101023");
        //101023
        System.out.println("Actual Output   : "+actual);
    }
}