import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Brute Force O(n^3) solution
        // Set<List<Integer>> st = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             if(nums[i]+nums[j]+nums[k] == 0){
        //                 List<Integer> temp = new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 temp.sort(null);
        //                 st.add(temp);
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> result = new ArrayList<>(st);
        // return result;

        // Better Solution O(n^2)
        // Set<List<Integer>> set = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     Set<Integer> tempSet = new HashSet<>();
        //     for(int j=i+1;j<nums.length;j++){
        //         int third = -(nums[i]+nums[j]);
        //         if(tempSet.contains(third)){
        //             List<Integer> temp = Arrays.asList(nums[i],nums[j],third);
        //             Collections.sort(temp);
        //             set.add(temp);
        //         }
        //         tempSet.add(nums[j]);
        //     }
        // }
        // return new ArrayList<>(set);


        //Optimal Approach Two Pointers
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k] == 0){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[k]==nums[k+1]) k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                }
                else if(nums[i]+nums[j]+nums[k] > 0){
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k] < 0){
                    j++;
                }
            }
        }
        return result;
    }   
}
public class ThreeSum {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};  // test case

        List<List<Integer>> result = sol.threeSum(nums);

        System.out.println("Triplets that sum to 0:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
