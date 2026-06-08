import java.util.Arrays;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        // Quick Sort partition is not stable
        int n = nums.length;

        int[] ans = new int[n];

        int i = 0;

        // elements smaller than pivot
        for(int num : nums) {
            if(num < pivot) {
                ans[i] = num;
                i++;
            }
        }

        // elements equal to pivot
        for(int num : nums) {
            if(num == pivot) {
                ans[i] = num;
                i++;
            }
        }

        // elements greater than pivot
        for(int num : nums) {
            if(num > pivot) {
                ans[i] = num;
                i++;
            }
        }

        return ans;
    }
}

public class partitionArrayGivenPivot {

    // helper method to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {9, 12, 5, 10, 14, 3, 10};

        int pivot = 10;

        System.out.print("Original Array: ");
        printArray(nums);

        System.out.println("Pivot Element: " + pivot);

        int[] result = sol.pivotArray(nums, pivot);

        System.out.print("Partitioned Array: ");
        printArray(result);

        // second test case
        int[] nums2 = {-3, 4, 3, 2};

        int pivot2 = 2;

        System.out.print("\nSecond Test Array: ");
        printArray(nums2);

        System.out.println("Second Pivot: " + pivot2);

        int[] result2 = sol.pivotArray(nums2, pivot2);

        System.out.print("Result After Partition: ");
        printArray(result2);
    }
}