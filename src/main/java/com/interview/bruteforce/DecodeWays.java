package com.interview.bruteforce;

public class DecodeWays {


    char arr[];
    Integer[] cache;

    public int numDecodings(String s) {
        this.arr  = s.toCharArray();
        this.cache  = new Integer[arr.length];
        return helper(0);
    }

    private int helper(int index){
        if(index == arr.length)
            return 1;
        if(cache[index] != null)
            return cache[index];

        int totalDecodeWays = 0;
        StringBuilder str = new StringBuilder();
        for(int i = index; i < arr.length && i < index + 2 ; i++ ){
            str.append(arr[i]);
            if(decodeCheck(str.toString())){
                totalDecodeWays += helper(i + 1);
            }
        }
        cache[index] = totalDecodeWays;
        return totalDecodeWays;
    }

    private boolean decodeCheck(String str){
        if(str.charAt(0) == '0')
            return false;
        return Integer.parseInt(str) < 27;
    }

}
