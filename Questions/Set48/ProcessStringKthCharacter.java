import java.util.*;

class Solution {

    public char processStr(String s, long k) {

        int n = s.length();

        long[] len = new long[n + 1];

        for(int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if(c == '*') {

                len[i + 1] =
                    Math.max(0, len[i] - 1);
            }
            else if(c == '#') {

                len[i + 1] =
                    Math.min(
                        Long.MAX_VALUE / 2,
                        len[i] * 2
                    );
            }
            else if(c == '%') {

                len[i + 1] = len[i];
            }
            else {

                len[i + 1] = len[i] + 1;
            }
        }

        if(k >= len[n]) return '.';

        for(int i = n - 1; i >= 0; i--) {

            char c = s.charAt(i);

            long prevLen = len[i];

            if(c == '#') {

                if(k >= prevLen) {
                    k -= prevLen;
                }
            }
            else if(c == '%') {

                k = prevLen - 1 - k;
            }
            else if(c == '*') {

                // nothing to do
            }
            else {

                if(k == prevLen) {
                    return c;
                }
            }
        }

        return '.';
    }
}

public class ProcessStringKthCharacter {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "ab#c%";

        long k = 2;

        System.out.println(
            "Input String: " + s
        );

        System.out.println(
            "Index k: " + k
        );

        char result =
            sol.processStr(s, k);

        System.out.println(
            "Character at index k: "
            + result
        );

        // second test case
        String s2 = "abc#";

        long k2 = 4;

        char result2 =
            sol.processStr(s2, k2);

        System.out.println(
            "\nSecond Test Answer: "
            + result2
        );
    }
}