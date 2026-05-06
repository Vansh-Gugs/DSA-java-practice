import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int x = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()>(nums.length/2)) x=e.getKey();
        }
        return x;
    }
}

public class majorityElementOne {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int result = sol.majorityElement(nums);

        System.out.println("Majority Element: " + result);
    }
}
