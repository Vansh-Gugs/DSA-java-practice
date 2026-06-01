import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        // Here, there is no need to first sort then make it descending, better to use below counter method to avoid an extra pass for reversing
        // int total_cost = 0;
        // Arrays.sort(cost);
        // int left = 0;
        // int right = cost.length-1;
        // while(left<right){
        //     int temp = cost[left];
        //     cost[left] = cost[right];
        //     cost[right] = temp;
        //     left++;
        //     right--;
        // }
        // for(int i=0;i<cost.length;i++){
        //     if((i+1)%3 != 0){
        //         total_cost = total_cost + cost[i];
        //     }
        // }
        // return total_cost;

        int total_cost = 0;
        Arrays.sort(cost);
        int count = 0;

        for(int i=cost.length-1;i>=0;i--){
            count ++;
            if(count%3 != 0){
                total_cost = total_cost + cost[i];
            }
        }
        return total_cost;
    }
}
public class minCostuyingCandies {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] cost = {6, 5, 7, 9, 2, 2};

        int result = sol.minimumCost(cost);

        System.out.println("Minimum Total Cost: " + result);
    }
}
