class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        if(nums[n-1]<target) return n;
        if(nums[0]>=target) return 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=target && nums[mid-1]<target) return mid;
            else if(target>nums[mid]) left = mid+1;
            else if(target<nums[mid]) right = mid-1;
        }
        return -1;
    }
}
public class searchInsertPosition {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 3, 5, 6};
        int target = 5;

        int result = sol.searchInsert(nums, target);

        System.out.println("Search Insert Position: " + result);
    }
}
