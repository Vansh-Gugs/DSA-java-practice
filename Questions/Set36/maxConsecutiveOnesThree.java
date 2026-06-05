class Solution {
    public int longestOnes(int[] nums, int k) {
        // Brute Force O(n^2)
        // int n = nums.length;
        // int longest = 0;
        // int zeros = 0;
        // for(int i=0;i<n;i++){
        //     zeros = 0;
        //     for(int j=i;j<n;j++){
        //         int curr_length;
        //         if(nums[j]==0) zeros++;
        //         if(zeros<=k){
        //             longest = Math.max(longest,j-i+1);
        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }
        // return longest;

        //Better Two Pointer & Sliding Window O(2n) worst case
        // int n = nums.length;
        // int longest = 0;
        // int zeros = 0;
        // int left = 0,right=0;
        // while(left<n && right<n){
        //     if(nums[right]==0) zeros++;
        //     if(zeros<=k){
        //         longest = Math.max(longest,right-left+1);
        //         right++;
        //     }
        //     else{
        //         // it is O(2n) because of this part, as it may need to move at most n times to reduce the zeros count in worst case, for e.g. 1 1 1 1 1 1 1 0 0 0 1 and k = 2, so this loop will run 8 times, which is near about n
        //         while(left<n && nums[left]==1) left++;
        //         zeros--;
        //         left++;
        //         right++;
        //     }
        // }
        // return longest;

        //Most Optimal, O(n) even in worst case approach, also Two Pointer and Sliding Window
        int n = nums.length;
        int longest = 0;
        int zeros = 0;
        int left = 0;
        int right = 0;
        while(right<n){
            if(nums[right]==0) zeros++;
            if(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++; // move left anyhow
            }
            //only update longest if zeros are less than equal to k
            if(zeros<=k) longest = Math.max(longest,right-left+1);
            
            //move right anyhow
            right++;
        }
        return longest;
    }
}

public class maxConsecutiveOnesThree {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int result = sol.longestOnes(nums, k);

        System.out.println("Longest Consecutive Ones: " + result);
    }
}
