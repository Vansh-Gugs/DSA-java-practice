import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b) -> Integer.compare(b[1]-b[0],a[1]-a[0]));
        int minCost = tasks[0][1];
        int remaining = minCost;
        for(int i=0;i<tasks.length;i++){
            if(remaining >= tasks[i][1]){
                remaining = remaining - tasks[i][0];
            }
            else{
                minCost = minCost + tasks[i][1]-remaining;
                remaining = tasks[i][1];
                remaining = remaining - tasks[i][0];
            }
        }
        return minCost;
    }
}

public class minInitialEnergy {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] tasks = {
            {1, 2},
            {2, 4},
            {4, 8}
        };

        int result = sol.minimumEffort(tasks);

        System.out.println("Minimum Initial Energy Required: " + result);
    }
}
