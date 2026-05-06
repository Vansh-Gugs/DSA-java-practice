import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()>(nums.length/3)) result.add(e.getKey());
        }
        return result;
    }
}
public class majorityElementTwo {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {3, 2, 3};

        List<Integer> result = sol.majorityElement(nums);

        System.out.println("Majority Elements (> n/3 times): " + result);
    }
}
