package com.interview.sorting.easy;

public class MajorityElement {
    public static void merge(int[] nums, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int i, j, k;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = nums[p + i];
        }

        for (j = 0; j < n2; j++) {
            R[j] = nums[q + j + 1];
        }

        i = 0;
        j = 0;
        k = p;


        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i = i + 1;
            } else {
                nums[k] = R[j];
                j = j + 1;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }

    }

    public static void partition(int[] nums, int p, int r) {

        int q;
        if (p < r) {
            q = (p + r) / 2;
            partition(nums, p, q);
            partition(nums, q + 1, r);
            merge(nums, p, q, r);
        }

    }

    public int majorityElement(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums[nums.length / 2];
    }

//    public int majorityElement(int[] num) {
//
//        int major=num[0], count = 1;
//        for(int i=1; i<num.length;i++){
//            if(count==0){
//                count++;
//                major=num[i];
//            }else if(major==num[i]){
//                count++;
//            }else count--;
//
//        }
//        return major;
//    }
}