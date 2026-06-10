import java.util.*;

class Solution {

    // Counts subarrays with sum <= goal
    public int getSum(int[] nums, int goal) {

        // edge case
        if(goal < 0) return 0;

        int n = nums.length;

        int left = 0;
        int right = 0;

        int total = 0;

        int sum = 0;

        while(right < n) {

            sum += nums[right];

            while(sum > goal) {

                sum = sum - nums[left];

                left++;
            }

            total += right - left + 1;

            right++;
        }

        return total;
    }

    public int numSubarraysWithSum(int[] nums,
                                   int goal) {

        return getSum(nums, goal)
             - getSum(nums, goal - 1);
    }
}

public class binarySubarraysWithSum {

    // helper method to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1, 0, 1, 0, 1};

        int goal = 2;

        System.out.print("Input Array: ");
        printArray(nums);

        System.out.println("Goal Sum: " + goal);

        int result =
            sol.numSubarraysWithSum(nums, goal);

        System.out.println(
            "Subarrays with exact sum: "
            + result
        );

        // second test case
        int[] nums2 = {0, 0, 0, 0, 0};

        int goal2 = 0;

        System.out.print("\nSecond Test Array: ");
        printArray(nums2);

        int ans2 =
            sol.numSubarraysWithSum(nums2, goal2);

        System.out.println(
            "Answer for second test: "
            + ans2
        );
    }
}