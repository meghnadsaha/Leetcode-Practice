package com.interview.bruteforce.array;

public class ZigzagConversion {

/*
    n=numRows
    Δ=2n-2    1                           2n-1                         4n-3
    Δ=        2                     2n-2  2n                    4n-4   4n-2
    Δ=        3               2n-3        2n+1              4n-5       .
    Δ=        .           .               .               .            .
    Δ=        .       n+2                 .           3n               .
    Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
    Δ=2n-2    n                           3n-2                         5n-4
*/

    public String convert(String s, int numRows) {
        //[[],[],[]]
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }

        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;

        //Traverse zig zag
        while(index < n){
            //Go down
            for(int j = 0; j < numRows && index < n; j++){
                sbs[j].append(arr[index++]);
            }
            //Go Up before start
            for(int j = numRows - 2; j > 0 && index < n; j--){
                sbs[j].append(arr[index++]);
            }
        }

        //Combine all stringbuilders into one
        StringBuilder res = sbs[0];
        for(int i = 1; i < numRows; i++){
            res.append(sbs[i].toString());
        }
        System.out.println("output : "+ res.toString());
        return res.toString();
    }
}
