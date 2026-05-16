class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[left] <= nums[mid]){ //means left half is sorted
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(target >= nums[mid] && target<=nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}

public class searchRotatedSortedArray {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = sol.search(nums, target);

        System.out.println("Target found at index: " + result);
    }
}
