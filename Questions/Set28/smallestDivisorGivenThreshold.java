class Solution {
    public int getSum(int[] nums, int divisor){
        int sum = 0;
        for(int num : nums){
            sum = sum + (int)Math.ceil((double)num/divisor);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        //Impossible case
        if(threshold<nums.length) return -1; //but constraints say there is no such test case
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max,num);
        }
        int left = 1;
        int right = max;
        while(left<=right){
            int mid = left + (right-left)/2;
            int sum = getSum(nums,mid);
            if(sum>threshold){ //if sum is greater, we need bigger divisor
                left = mid+1;
            }
            else{ //if sum is lesser, there may still be a smaller divisor
                right = mid-1;
            }
        }
        return left;
    }
}
public class smallestDivisorGivenThreshold {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        int result = sol.smallestDivisor(nums, threshold);

        System.out.println("Smallest Divisor: " + result);
    }
}
