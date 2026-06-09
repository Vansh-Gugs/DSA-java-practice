import java.util.Arrays;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(long num:nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        long result = (max-min) * k;
        return result;
    }
}
public class maxTotalSubarrayValueOne {
     public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1, 3, 6, 10};

        int k = 4;

        System.out.print("Input Array: ");
        printArray(nums);

        System.out.println("Value of k: " + k);

        long result = sol.maxTotalValue(nums, k);

        System.out.println("Maximum Total Value: "
                           + result);

        // second test case
        int[] nums2 = {5, 5, 5, 5};

        int k2 = 3;

        System.out.print("\nSecond Test Array: ");
        printArray(nums2);

        long ans2 = sol.maxTotalValue(nums2, k2);

        System.out.println("Answer for second test: "
                           + ans2);
    }
}
