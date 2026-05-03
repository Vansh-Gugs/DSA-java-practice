class Solution {
    public int maxSubArray(int[] nums) {
        //  O(n^2) solution
        // int max_sum= Integer.MIN_VALUE;
        // int sum_before_neg = 0;int sum_after_neg = 0;
        // for(int i=0;i<nums.length;i++){
        //     int sum = 0;
        //     for(int j=i;j<nums.length;j++){
        //         sum = sum + nums[j];
        //         if(sum>max_sum) max_sum = sum;
        //     }
        // }
        // return max_sum;

        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            if(sum>max_sum) max_sum = sum;
            if(sum<0) sum = 0;
        }
        return max_sum;
    }
}
public class maxSubarray {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};  // test case

        int result = sol.maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
