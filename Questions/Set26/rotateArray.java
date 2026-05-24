import java.util.Arrays;

class Solution {
    public void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        // not optimal, extra space
        // int n = nums.length;
        // k = k%n;
        // if(n==1 || k==0) return;
        // int index = n-k;
        // int[] result = new int[n];
        // int i = 0;
        // do{
        //     result[i] = nums[index];
        //     i++;
        //     index = (index+1)%n;
        // }while(index != (n-k));
        // for(i = 0;i<nums.length;i++){
        //     nums[i] = result[i];
        // }

        //optimal in-place approach
        int n = nums.length;
        k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
}

public class rotateArray{
     public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.print("Original Array: ");
        printArray(nums);

        sol.rotate(nums, k);

        System.out.print("Rotated Array:  ");
        printArray(nums);
    }
}