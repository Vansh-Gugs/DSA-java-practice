import java.util.*;

class Solution {

    public String[] createGrid(int m, int n) {

        String[] result = new String[m];

        if(m == 1 && n == 1) {
            result[0] = ".";
            return result;
        }

        for(int i = 0; i < m; i++) {

            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < n; j++) {

                if(i == 0) {
                    sb.append(".");
                }
                else if(j == n - 1) {
                    sb.append(".");
                }
                else {
                    sb.append("#");
                }
            }

            result[i] = sb.toString();
        }

        return result;
    }
}

public class CreateGrid {

    public static void printGrid(String[] grid) {
        for(String row : grid) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int m = 4;
        int n = 5;

        System.out.println("Grid Size: " + m + " x " + n);

        String[] result = sol.createGrid(m, n);

        System.out.println("\nGenerated Grid:");
        printGrid(result);

        // second test case
        int m2 = 1;
        int n2 = 1;

        System.out.println("\nSecond Grid:");

        String[] result2 = sol.createGrid(m2, n2);

        printGrid(result2);
    }
}