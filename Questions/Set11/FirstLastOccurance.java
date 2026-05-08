import java.util.Arrays;

class Solution {
    public int findFirst(int[] nums,int target,int n){
        int left = 0;
        int right = n-1;
        if(nums[0]==target) return 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target && nums[mid-1]!=target){
                return mid;
            }
            else if(target > nums[mid]) left = mid+1;
            else if(target < nums[mid]) right = mid-1;
            else if(nums[mid-1]==target) right=mid-1;
        }
        return -1;
    }

    public int findLast(int[] nums,int target,int n){
        int left = 0;
        int right = n-1;
        if(nums[n-1]==target) return (n-1);
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target && nums[mid+1]!=target){
                return mid;
            }
            else if(target > nums[mid]) left = mid+1;
            else if(target < nums[mid]) right = mid-1;
            else if(nums[mid+1]==target) left=mid+1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int n = nums.length;
        if(nums.length==0) return result;
        int first = findFirst(nums,target,n);
        int last = findLast(nums,target,n);
        result[0] = first;
        result[1] = last;
        return result;
    }
}
public class FirstLastOccurance {
     // Helper to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = sol.searchRange(nums, target);

        System.out.print("First and Last Position: ");
        printArray(result);
    }
}
