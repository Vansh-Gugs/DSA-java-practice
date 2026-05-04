import java.util.Arrays;

class Solution {

    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void reverse(int[] arr,int start,int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for(int i = n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        if(index==-1){ // if there was no break index, means it was the last permutation
            reverse(nums,0,n-1);
            return;
        }

        // we got the smallest larger element from arr[index]
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[index]){
                swap(nums ,i ,index);
                break;
            }
        }

        // Reverse the remaining arra
        reverse(nums,index+1,n-1);
        return;
    }
}
public class nextPermutation {
     // Helper to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 2, 3};  // test case

        System.out.print("Original: ");
        printArray(nums);

        sol.nextPermutation(nums);

        System.out.print("Next Permutation: ");
        printArray(nums);
}
