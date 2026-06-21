import java.util.*;

class Solution {

    public int maxIceCream(int[] costs, int coins) {

        // This would be optimal, but problem requires
        // counting sort approach

        // Arrays.sort(costs);
        // int count = 0;
        //
        // for(int cost : costs) {
        //     if(coins >= cost) {
        //         count++;
        //         coins -= cost;
        //     }
        // }
        //
        // return count;

        // Counting sort method
        int[] freq = new int[100001];

        for(int cost : costs) {
            freq[cost]++;
        }

        int total = 0;

        for(int cost = 1; cost < 100001; cost++) {

            if(freq[cost] == 0) continue;

            int canBuy =
                Math.min(freq[cost], coins / cost);

            total += canBuy;

            coins -= cost * canBuy;

            if(coins < cost) break;
        }

        return total;
    }
}

public class MaximumIceCreamBars {

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] costs = {1, 3, 2, 4, 1};

        int coins = 7;

        System.out.print("Ice Cream Costs: ");
        printArray(costs);

        System.out.println("Coins Available: " + coins);

        int result =
            sol.maxIceCream(costs, coins);

        System.out.println(
            "Maximum Ice Cream Bars: "
            + result
        );

        // second test case
        int[] costs2 = {10, 6, 8, 7, 7, 8};

        int coins2 = 5;

        System.out.print("\nSecond Costs Array: ");
        printArray(costs2);

        System.out.println(
            "Coins Available: " + coins2
        );

        int result2 =
            sol.maxIceCream(costs2, coins2);

        System.out.println(
            "Maximum Ice Cream Bars: "
            + result2
        );
    }
}