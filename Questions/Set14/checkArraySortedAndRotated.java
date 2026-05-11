class Solution {
    public boolean check(int[] nums) {

        /* there must only 1 point where the count increases if it is sorted
        but it will be 0 if all elements are the same in array
        if it is not sorted, count is >1
        */

        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > nums[(i+1)%nums.length]){
                count++;
            }
        }
        if(count<=1){
            return true;
        }
        return false;
    }
}
public class checkArraySortedAndRotated {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {3, 4, 5, 1, 2};

        boolean result = sol.check(nums);

        System.out.println("Is sorted and rotated: " + result);
    }
}
