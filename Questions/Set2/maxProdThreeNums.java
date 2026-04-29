import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        int prod = 1;
        int n = nums.length;
        Arrays.sort(nums);
        prod = Math.max(nums[0]*nums[1]*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
        return prod;
    }
}
public class maxProdThreeNums {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {-10, -10, 5, 2};  // test case

        int result = sol.maximumProduct(nums);

        System.out.println("Maximum Product of Three Numbers: " + result);
    }
}
