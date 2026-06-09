import java.util.Arrays;
import java.util.HashMap;

class Solution {
    // this solves for subarrays with distinct <=k and not distinct==k
    public int atMost(int[] nums, int k){
        int n = nums.length;
        // map of number and freq
        HashMap<Integer,Integer> map = new HashMap<>();
        int left=0,right=0;
        int total=0;
        while(right<n){
            if(!map.containsKey(nums[right])){
                map.put(nums[right],1);
            }
            else{
                map.put(nums[right],map.get(nums[right])+1);
            }
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
            total += right-left+1;
            right++;
        }
        return total;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        // O(n^2) solution, its TLE
        // int n = nums.length;
        // int total = 0;
        // Set<Integer> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     set.add(nums[i]);
        //     for(int j=i;j<n;j++){
        //         set.add(nums[j]);
        //         if(set.size()==k) total++;
        //         if(set.size()>k) break;
        //     }
        //     set.clear();
        // }
        // return total;

        //Optimal Sliding Approach Solution
        // this is because we are solving for subarrays with distict == k, so for distinct==k we can do (distinct<=k - distinct<=k-1)
        return atMost(nums,k) - atMost(nums,k-1);
    }
}
public class subarraysWithKDistinctIntegers {
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1, 2, 1, 2, 3};

        int k = 2;

        System.out.print("Input Array: ");
        printArray(nums);

        System.out.println("Value of k: " + k);

        int result =
            sol.subarraysWithKDistinct(nums, k);

        System.out.println(
            "Subarrays with exactly k distinct: "
            + result
        );

        // second test case
        int[] nums2 = {1, 2, 1, 3, 4};

        int k2 = 3;

        System.out.print("\nSecond Test Array: ");
        printArray(nums2);

        int ans2 =
            sol.subarraysWithKDistinct(nums2, k2);

        System.out.println(
            "Answer for second test: " + ans2
        );
}
