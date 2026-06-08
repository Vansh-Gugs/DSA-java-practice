class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum=0,rightSum=0,maxSum=0;
        // first take all k elements from the left
        for(int i=0;i<k;i++) leftSum += cardPoints[i];
        //maxSum can be initialised as this leftSum initially
        maxSum = leftSum;
        // Remove one element from left and add one element from the right and keep max sum
        int right = n-1;
        for(int left=k-1;left>=0;left--){
            leftSum = leftSum - cardPoints[left];
            rightSum = rightSum + cardPoints[right];
            right--;
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}


public class maxPointsFromCards {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        int result = sol.maxScore(cardPoints, k);

        System.out.println("Maximum Score: " + result);
    }
}
