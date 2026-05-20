import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public long[] distance(int[] nums) {
    // Brute Force O(n^2), TLE
    //     int n = nums.length;
    //     long[] arr = new long[n];

    //     for(int i=0;i<n;i++){
    //         int sum = 0;
    //         for(int j=0;j<n;j++){
    //             if(i!=j && nums[i]==nums[j]){
    //                 sum += Math.abs(i-j);
    //             }
    //         }
    //         arr[i] = sum;
    //     }
    //     return arr;
    // 

    // Make map of nums[i] -> all indices at which nums[i] present
        int n = nums.length;
        long[] arr = new long[n];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }
            else{
                map.put(nums[i],new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }
         
        // Optimal
        for(List<Integer> indices : map.values()){
            int size = indices.size();
            long[] prefix = new long[size];
            prefix[0] = indices.get(0);
            for(int i=1;i<size;i++){
                prefix[i] = prefix[i-1] + indices.get(i);
            }

            for(int i=0;i<size;i++){
                int index = indices.get(i);

                // Left Sum
                long leftSum = 0; // this is total left sum
                if(i>0) leftSum = prefix[i-1];
                long leftCount = i;
                long left = (index*leftCount) - leftSum; //this is sum after subtracting the index |i-j| wala part

                //Right Sum
                long rightSum = prefix[size-1] - prefix[i];
                long rightCount = size-1-i;
                long right = rightSum - (index*rightCount);

                arr[index] = left+right;
            }
        }
        return arr;
        


        //Better than Brute but still not good enough
        // for(int i=0;i<n;i++){
        //     int sum = 0;
        //     List<Integer> indices = map.get(nums[i]);
        //     for(int j=0;j<indices.size();j++){
        //         if(i!=indices.get(j)) sum += Math.abs(i-indices.get(j));
        //     }
        //     arr[i] = sum;
        // }
        // return arr;
    }
}
public class sumOfDistances {
    public static void printArray(long[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 3, 1, 1, 2};

        long[] result = sol.distance(nums);

        System.out.print("Distance Array: ");
        printArray(result);
    }
}
