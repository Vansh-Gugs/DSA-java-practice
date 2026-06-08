import java.util.*;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0, rightSum = 0, maxSum = 0;

        // first take all k elements from the left
        for(int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        // initialise maxSum
        maxSum = leftSum;

        // Remove one from left and add one from right
        int right = n - 1;

        for(int left = k - 1; left >= 0; left--) {

            leftSum = leftSum - cardPoints[left];

            rightSum = rightSum + cardPoints[right];

            right--;

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}

public class maxPointsFromCards {

    // helper method to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};

        int k = 3;

        System.out.print("Card Points Array: ");
        printArray(cardPoints);

        System.out.println("Value of k: " + k);

        int result = sol.maxScore(cardPoints, k);

        System.out.println("Maximum Score: " + result);

        // extra test case
        int[] test2 = {2, 2, 2};

        System.out.print("\nSecond Test Array: ");
        printArray(test2);

        int ans2 = sol.maxScore(test2, 2);

        System.out.println("Maximum Score for second test: " + ans2);
    }
}