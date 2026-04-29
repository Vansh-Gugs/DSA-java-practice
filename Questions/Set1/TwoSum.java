import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // O(n^2) solution
        // int[] result = new int[2];
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             result[0] = i;
        //             result[1] = j;
        //             break;
        //         }
        //     }
        // }
        // return result;

        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            else{
                map.put(target-nums[i],i);
            }
        }
        return result;
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = sol.twoSum(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}