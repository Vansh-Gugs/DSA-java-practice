class Solution {
    public int maxArea(int[] height) {
        //O(n^2), TLE
        // int max = 0;
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         int curr_amount = (j-i)*Math.min(height[i],height[j]);
        //         if(curr_amount>max) max = curr_amount;
        //     }
        // }
        // return max;

        //Optimal
        int max = 0;
        int i=0,j=height.length-1;
        while(i<j){
            int curr_amount = (j-i)*Math.min(height[i],height[j]);
            if(curr_amount>max) max = curr_amount;
            if(height[i]<height[j]) i++;
            else j--;
        }
        return max;
    }
}

public class ContainMostWater {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] height = {1,8,6,2,5,4,8,3,7};

        int result = sol.maxArea(height);

        System.out.println("Maximum Area: " + result);
    }
}

