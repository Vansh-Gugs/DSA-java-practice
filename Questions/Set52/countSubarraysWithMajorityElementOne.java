import java.util.*;

class Solution {

    public int countMajoritySubarrays(int[] nums,
                                      int target) {

        int n = nums.length;

        // If it is the target, make it +1
        // otherwise make it -1
        //
        // So if sum of a subarray > 0,
        // target is majority in that subarray
        //
        // We build prefix sum so subarray sum
        // can be found in O(1)

        int[] prefix = new int[n + 1];

        for(int i = 0; i < n; i++) {

            if(nums[i] == target) {
                nums[i] = 1;
            }
            else {
                nums[i] = -1;
            }

            prefix[i + 1] =
                prefix[i] + nums[i];
        }

        int count = 0;

        for(int left = 0; left < n; left++) {

            for(int right = left;
                right < n;
                right++) {

                int sum =
                    prefix[right + 1]
                    - prefix[left];

                if(sum > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

public class countSubarraysWithMajorityElementOne {

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {2, 1, 2, 2};

        int target = 2;

        System.out.print("Input Array: ");
        printArray(nums);

        System.out.println(
            "Target = " + target
        );

        int result =
            sol.countMajoritySubarrays(
                nums,
                target
            );

        System.out.println(
            "Majority Subarrays Count: "
            + result
        );

        // second test case
        int[] nums2 = {1, 2, 3};

        int target2 = 2;

        System.out.print("\nSecond Array: ");
        printArray(nums2);

        int ans2 =
            sol.countMajoritySubarrays(
                nums2,
                target2
            );

        System.out.println(
            "Answer for second test: "
            + ans2
        );
    }
}