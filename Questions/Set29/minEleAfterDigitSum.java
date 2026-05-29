class Solution {
    public int getSum(int num){
        int sum = 0;
        while(num>0){
            int digit = num%10;
            sum = sum+digit;
            num = num/10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            nums[i] = getSum(nums[i]);
            min = Math.min(min,nums[i]);
        }
        return min;
    }
}
public class minEleAfterDigitSum {
     public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {10, 12, 13, 14};

        int result = sol.minElement(nums);

        System.out.println("Minimum Element After Digit Sum Replacement: " + result);
    }
}
