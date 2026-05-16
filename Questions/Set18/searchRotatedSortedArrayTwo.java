class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left=0,right=n-1;
        // the same as search in rotated sorted array 1
        //the only test case that fail are when left mid and right all are same
        //so need to just add one more condition
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return true;
            if(nums[left] == nums[mid]  && nums[mid] == nums[right]){
                left++;
                right--;
                continue; // we just need to shrink the search space if all are duplicate as if they are duplicate we cant identify which portion is sorted and which portion to move to
            }
            else if(nums[left]<=nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid +1;
                }
            }
            else{
                if(target <= nums[right] && target >= nums[mid]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}

public class searchRotatedSortedArrayTwo {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        boolean result = sol.search(nums, target);

        System.out.println("Target found: " + result);
    }
}
