class Solution {
    public int climbStairs(int n) {
        // It forms a fibonacci sequence
        if(n==0) return 0;
        if(n==1) return 1;
        int v1 = 1, v2 = 1, sum = 0;
        for(int i=2;i<=n;i++){
            sum = v1+v2;
            v1 = v2;
            v2 = sum;
        }
        return sum;
    }
}

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 5;  // number of stairs

        int result = sol.climbStairs(n);

        System.out.println("Number of ways to climb " + n + " stairs: " + result);
    }
}