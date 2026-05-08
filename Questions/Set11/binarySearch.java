class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}
public class binarySearch {
    public static void main(String[] args){
        Solution sol = new Solution();

        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        int index = sol.search(nums, target);
        System.out.println("The target was found at index : "+index);
    } 
}
