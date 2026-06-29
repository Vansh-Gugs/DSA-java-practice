import java.util.*;

class Solution {

    // public boolean isSubStr(String pattern, String word){
    //     boolean flag = false;
    //
    //     while(word.length() > 0){
    //         if(word.startsWith(pattern)){
    //             flag = true;
    //             break;
    //         }
    //         else{
    //             word = word.substring(1, word.length());
    //         }
    //     }
    //
    //     return flag;
    // }

    public int numOfStrings(String[] patterns,
                            String word) {

        // int count = 0;
        //
        // for(String pattern : patterns){
        //     if(isSubStr(pattern, word)) {
        //         count++;
        //     }
        // }
        //
        // return count;

        int count = 0;

        for(String pattern : patterns) {

            if(word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }
}

public class NumberOfStringsAsSubstrings {

    public static void printArray(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        String[] patterns = {
            "a",
            "abc",
            "bc",
            "d"
        };

        String word = "abc";

        System.out.print("Patterns: ");
        printArray(patterns);

        System.out.println("Word: " + word);

        int result =
            sol.numOfStrings(patterns, word);

        System.out.println(
            "Matching Pattern Count: "
            + result
        );

        // second test case
        String[] patterns2 = {
            "x",
            "xy",
            "yz"
        };

        String word2 = "xyz";

        System.out.print("\nSecond Patterns: ");
        printArray(patterns2);

        System.out.println("Word: " + word2);

        int result2 =
            sol.numOfStrings(patterns2, word2);

        System.out.println(
            "Answer for second test: "
            + result2
        );
    }
}