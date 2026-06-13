import java.util.*;

class Solution {

    public int characterReplacement(String s, int k) {

        int n = s.length();

        int left = 0;
        int right = 0;

        int maxLen = 0;
        int maxFreq = 0;

        int[] freq = new int[26];

        while(right < n) {

            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(
                maxFreq,
                freq[s.charAt(right) - 'A']
            );

            if((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;

                left++;
            }

            if((right - left + 1) - maxFreq <= k) {

                maxLen = Math.max(
                    maxLen,
                    right - left + 1
                );
            }

            right++;
        }

        return maxLen;
    }
}

public class longestRepeatingCharReplacement {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "ABAB";

        int k = 2;

        System.out.println(
            "Input String: " + s
        );

        System.out.println(
            "Value of k: " + k
        );

        int result =
            sol.characterReplacement(s, k);

        System.out.println(
            "Longest Valid Length: "
            + result
        );

        // second test case
        String s2 = "AABABBA";

        int k2 = 1;

        System.out.println(
            "\nSecond String: " + s2
        );

        int ans2 =
            sol.characterReplacement(s2, k2);

        System.out.println(
            "Answer for second test: "
            + ans2
        );
    }
}
