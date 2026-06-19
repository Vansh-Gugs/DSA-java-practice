import java.util.*;

class Solution {

    public int largestAltitude(int[] gain) {

        int n = gain.length;

        int max = 0;
        int sum = 0;

        for(int g : gain) {

            sum = sum + g;

            max = Math.max(max, sum);
        }

        return max;
    }
}

public class FindHighestAltitude {

    // helper method
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] gain = {-5, 1, 5, 0, -7};

        System.out.print("Gain Array: ");
        printArray(gain);

        int result = sol.largestAltitude(gain);

        System.out.println("Highest Altitude: " + result);

        // second test case
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};

        System.out.print("\nSecond Gain Array: ");
        printArray(gain2);

        int result2 = sol.largestAltitude(gain2);

        System.out.println("Highest Altitude: " + result2);
    }
}