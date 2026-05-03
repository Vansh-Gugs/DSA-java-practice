class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0,j=1;
        while(j<n){
            if(nums[i]!=nums[j]){
                nums[++i] = nums[j];
                j++;
            }
            else{
                j++;
            }
        }
        return i+1;
    }
}

public class removeDuplicatedSortedArray {
     // Helper to print first k elements
    public static void printArray(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {0,0,1,1,1,2,2,3,3,4};  // test case

        int k = sol.removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Array after removing duplicates: ");
        printArray(nums, k);
    }
}
