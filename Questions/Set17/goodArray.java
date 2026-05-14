import java.util.Arrays;

class Solution {
    public boolean isGood(int[] nums) {

        // O(n) TC but O(n) space for map, so sorting is better
        // HashMap<Integer,Integer> map = new HashMap<>();//value frequency map
        // int max = Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     max = Integer.max(nums[i],max);
        //     if(!map.containsKey(nums[i])) map.put(nums[i],1);
        //     else map.put(nums[i],map.get(nums[i])+1);
        // }
        // for(int i=1;i<=max;i++){
        //     if(i!=max){
        //         if(map.containsKey(i) && map.get(i)==1) continue;
        //         else return false;
        //     }
        //     else{
        //         if(map.get(i)!=2){
        //             return false;
        //         }
        //     }
        // }
        // return true;

        // Sorting approach
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] != i+1){
                return false;
            }
        }
        if(nums[nums.length-1] == nums.length-1){
            return true;
        }
        return false;
    }
}

public class goodArray{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 1, 3, 3};

        boolean result = sol.isGood(nums);

        System.out.println("Is array good? " + result);
    }
}