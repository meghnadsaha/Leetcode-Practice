package com.interview.random.google;

public class MaximumPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        int[] cummulativeSumFromFront = new int[n + 1];
        int[] cummulativeSumFromBehind = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum += cardPoints[i];
            cummulativeSumFromFront[i + 1] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += cardPoints[i];
            cummulativeSumFromBehind[i] = sum;
        }
        rvereseArray(cummulativeSumFromBehind, 0, n);

        int answer = 0;
        for (int i = 0; i <= k; i++) {
            answer = Math.max(answer, cummulativeSumFromFront[i] + cummulativeSumFromBehind[k - i]);
                                     // Sum of last 'k-i' cards. + Sum of first 'i' cards.
        }
        return answer;
    }

    static void rvereseArray(int arr[],
                             int start, int end) {
        int temp;

        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int cardPoints[] = {1, 2, 3, 4, 5, 6, 1}, k = 3;

//        int cardPoints[] = {2,2,2}, k = 2;
        System.out.println(maxScore(cardPoints, k));
    }


}