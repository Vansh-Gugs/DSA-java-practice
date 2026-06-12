import java.util.*;

class Solution {

    // Count substrings containing all three characters
    public int numberOfSubstrings(String s) {

        int n = s.length();

        long totalSubstrings =
            ((long) n * (n + 1)) / 2;

        int count = 0; // substrings with <= 2 distinct chars

        int left = 0;
        int right = 0;

        HashMap<Character, Integer> map =
            new HashMap<>();

        while(right < n) {

            char c = s.charAt(right);

            if(!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }

            while(map.size() > 2) {

                char leftChar =
                    s.charAt(left);

                map.put(leftChar,
                        map.get(leftChar) - 1);

                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            count += right - left + 1;

            right++;
        }

        return (int) totalSubstrings - count;
    }
}

public class numOfSubstrsWithAllThreeChars {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "abcabc";

        System.out.println(
            "Input String: " + s
        );

        int result =
            sol.numberOfSubstrings(s);

        System.out.println(
            "Substrings containing a, b and c: "
            + result
        );

        // second test case
        String s2 = "aaacb";

        System.out.println(
            "\nSecond String: " + s2
        );

        int ans2 =
            sol.numberOfSubstrings(s2);

        System.out.println(
            "Answer for second test: "
            + ans2
        );
    }
}