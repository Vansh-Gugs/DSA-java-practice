import java.util.*;

class Solution {

    public String mapWordWeights(String[] words,
                                 int[] weights) {

        StringBuilder sb = new StringBuilder();

        for(String word : words) {

            int total = 0;

            for(char c : word.toCharArray()) {

                total += weights[c - 'a'];
            }

            total = total % 26;

            sb.append((char)('z' - total));
        }

        return sb.toString();
    }
}

public class MapWordWeights {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String[] words = {"abc","dog","cat"};

        // weights for a-z
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12, 13, 14, 15, 16, 17, 18,19, 20, 21, 22, 23, 24, 25, 26};

        System.out.println("Words:");
        System.out.println(Arrays.toString(words));

        String result = sol.mapWordWeights(words, weights);

        System.out.println("Mapped String: " + result);

        // second test case
        String[] words2 = {"a","b","z"};

        String result2 = sol.mapWordWeights(words2, weights);

        System.out.println("\nSecond Test Result: " + result2);
    }
}