package com.interview.string.easy;

public class RemoveDigit {

    public String removeDigit(String number, char digit) {
        String maxValue = "";

        for(int i=0;i<number.length();i++)
            if (number.charAt(i) == digit)
            {
                String  newNumber = number.substring(0,i) + number.substring(i+1);
                System.out.println(newNumber);
                if (newNumber.compareTo(maxValue) > 0) {
                    maxValue = newNumber;
                }
            }
        return maxValue;

    }

    public static void main ( String[] args ) {
        String number = "123";
        char digit = '3';
        RemoveDigit removeDigit= new RemoveDigit();
        System.out.println(removeDigit.removeDigit(number,digit));
    }
}
