class Solution {
    public int findMin(int[] nums) {
        // int n = nums.length;
        // int left = 0,right = n-1;
        // /*since array is sorted in asc order,
        // need to find the breaking point from which rotation has started 
        // because that index will hold the minimum value*/
        // if(nums[left]<=nums[right]) return nums[left];
        // while(left<=right){
        //     int mid = left + (right-left)/2;
        //     if(mid > 0 && nums[mid-1]>nums[mid]) return nums[mid];
        //     else if(nums[mid]>nums[right]){ //move towards unsorted portion
        //         left = mid+1;
        //     }
        //     else if(nums[left]>nums[mid]){ //move towards unsorted portion
        //         right = mid-1;
        //     }
        //     else if(nums[mid]>nums[left] && nums[mid]<nums[right]){
        //         return nums[left]; //if both portion are sorted, then the smallest will obviously be the nums[left]
        //     }
        // }
        // return -1;


        //Simpler version
        int n = nums.length;
        int left = 0,right=n-1;
        int min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[left]<=nums[mid]){ //means left portion sorted
                min = Math.min(min,nums[left]);
                left = mid+1; //eliminate left half after finding min of this sorted portion
            }
            else{ //right portion sorted
                min = Math.min(min,nums[mid]);
                right = mid-1; //eliminate right half after finding min
            }
        }
        return min;
    }
}
public class findMinRotatSortdArr {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {3, 4, 5, 1, 2};

        int result = sol.findMin(nums);

        System.out.println("Minimum element: " + result);
    }
}
