class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0,right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[left] <= nums[mid] && nums[mid]!=nums[right]){ //means left portion is sorted
                min = Math.min(min,nums[left]);
                left = mid+1;
            }
            else if(nums[mid] <= nums[right] && nums[mid]!=nums[left]){ //means right portion is sorted
                min = Math.min(min,nums[mid]);
                right = mid-1;
            }
            else if(nums[left]==nums[mid] && nums[mid]==nums[right]){
                min = Math.min(min,nums[mid]);
                left++;
                right--;
            }
        }
        return min;
    }
}
public class findMinRotatSortdArrTwo {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 2, 2, 0, 1};

        int result = sol.findMin(nums);

        System.out.println("Minimum element: " + result);
    }
}
