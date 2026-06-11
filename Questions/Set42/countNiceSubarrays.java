import java.util.*;

class Solution {

    public boolean isOdd(int n) {
        return n % 2 == 1;
    }

    // Counts subarrays with at most k odd numbers
    public int atMostNice(int[] nums, int k) {

        int n = nums.length;

        int left = 0;
        int right = 0;

        int count = 0;

        int odd = 0;

        while(right < n) {

            if(isOdd(nums[right])) {
                odd++;
            }

            while(odd > k) {

                if(isOdd(nums[left])) {
                    odd--;
                }

                left++;
            }

            count += right - left + 1;

            right++;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        return atMostNice(nums, k)
             - atMostNice(nums, k - 1);
    }
}

public class countNiceSubarrays {

    // helper method
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1, 1, 2, 1, 1};

        int k = 3;

        System.out.print("Input Array: ");
        printArray(nums);

        System.out.println("Value of k: " + k);

        int result =
            sol.numberOfSubarrays(nums, k);

        System.out.println(
            "Number of Nice Subarrays: "
            + result
        );

        // second test case
        int[] nums2 = {2, 4, 6};

        int k2 = 1;

        System.out.print("\nSecond Test Array: ");
        printArray(nums2);

        int ans2 =
            sol.numberOfSubarrays(nums2, k2);

        System.out.println(
            "Answer for second test: "
            + ans2
        );
    }
}