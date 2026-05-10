class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int count = 0;
        int n = nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==1){
                count++;
                max_count = Math.max(count,max_count);
                i++;
            }
            else if(nums[i]==0){
                count = 0;
                i++;
            }
        }
        return max_count;
    }
}
public class maxConsecOnes {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] arr = {1,1,1,0,0,1,0,1,0,1,1,1,1,0,1,1,0};
        System.out.println("The maximum consecutive ones are: "+ sol.findMaxConsecutiveOnes(arr));
    }
}
