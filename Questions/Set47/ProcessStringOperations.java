import java.util.*;

class Solution {

    public String processStr(String s) {

        StringBuilder result = new StringBuilder();

        for(char c : s.toCharArray()) {

            if(c == '*') {

                if(result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            }
            else if(c == '#') {

                result.append(result);
            }
            else if(c == '%') {

                result.reverse();
            }
            else {

                result.append(c);
            }
        }

        return result.toString();
    }
}

public class ProcessStringOperations {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "ab#c%";

        System.out.println("Input String: " + s);

        String result = sol.processStr(s);

        System.out.println("Processed String: " + result);

        // second test case
        String s2 = "abc*d#";

        System.out.println("\nSecond Input: " + s2);

        String result2 = sol.processStr(s2);

        System.out.println("Processed String: " + result2);
    }
}