import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Correct with TC O(n*logn) but not optimal
        // if(nums.length==0) return 0;
        // Arrays.sort(nums);
        // int max_count = 1;
        // int count=1;
        // for(int i=0;i<nums.length;i++){
        //     if(i<nums.length-1 && nums[i]==nums[i+1]) continue;
        //     if(i<nums.length-1 && (nums[i]+1)==nums[i+1]){
        //         count++;
        //         if(count>max_count) max_count = count;
        //     }
        //     else{
        //         count = 1;
        //     }
        // }
        // return max_count;

        //Optimal with O(n)
        if(nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 1;
        for(int x : set){
            if(!set.contains(x-1)){
                int count = 1;
                while(set.contains(x+1)){
                    count++;
                    x++;
                }
                if(count>longest){
                    longest = count;
                }
            }
        }
        return longest;
    }
}

public class LongestConsecSeq {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {100, 4, 200, 1, 3, 2};  // test case

        int result = sol.longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
