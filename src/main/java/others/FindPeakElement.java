package others;

public class FindPeakElement {
    public static int findPeakElement ( int[] nums ) {
        int n = nums.length;
        if(n == 1 || nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;
        int l = 0;
        int r = n - 1;
        while(l <= r)
        {
            int m = (l + r)/2;
            int minus = m == 0 ? Integer.MIN_VALUE : nums[m-1];
            int plusUltra = m == n - 1 ? Integer.MIN_VALUE : nums[m+1];
            if(minus < nums[m] && plusUltra < nums[m]) return m;
            if(minus < nums[m]) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
    public static void main(String args[]){
        int[] nums= {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}
