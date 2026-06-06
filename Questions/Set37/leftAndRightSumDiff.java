import java.util.Arrays;

class Solution {
    public int[] leftRightDifference(int[] nums) {
        // Takes Extra space
        // int n = nums.length;
        // int[] result = new int[n];
        // if(n==1){
        //     result[0] = 0;
        //     return result;
        // }
        // int[] leftSum = new int[n];
        // int[] rightSum = new int[n];
        // leftSum[0] = 0;
        // rightSum[n-1] = 0;
        // int i=1,j=n-2;
        // int lSum=0,rSum=0;
        // while(i<n && j>=0){
        //     lSum = lSum+nums[i-1];
        //     rSum = rSum+nums[j+1];
        //     leftSum[i] = lSum;
        //     rightSum[j] = rSum;
        //     i++;
        //     j--; 
        // }
        // for(i=0;i<n;i++){
        //     result[i] = Math.abs(leftSum[i]-rightSum[i]);
        // }
        // return result;

        // Does not allocate extra arrays for left and right
        int n = nums.length;
        int[] result = new int[n];
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int leftSum = 0;
        for(int i=0;i<n;i++){
            int rightSum = totalSum - nums[i];
            totalSum = totalSum - nums[i];
            result[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }
        return result;
    }
}

public class leftAndRightSumDiff {
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {10, 4, 8, 3};

        int[] result = sol.leftRightDifference(nums);

        System.out.print("Left Right Difference Array: ");
        printArray(result);
    }
}
