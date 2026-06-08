import java.util.Arrays;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // Quick Sort Partition will not work here as that is not stable(does not maintain relative order)
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        for(int num:nums){
            if(num<pivot){
                ans[i] = num;
                i++;
            }
        }
        for(int num:nums){
            if(num==pivot){
                ans[i] = num;
                i++;
            }
        }
        for(int num:nums){
            if(num>pivot){
                ans[i] = num;
                i++;
            }
        }
        return ans;
    }
}
public class partitionArrayGivenPivot {
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int[] result = sol.pivotArray(nums, pivot);

        System.out.print("Partitioned Array: ");
        printArray(result);
    }
}
