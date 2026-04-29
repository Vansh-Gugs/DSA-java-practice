import java.util.HashSet;
import java.util.Set;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding window
        /*right is increased and charAt(right)inserted in set until a duplicate if found
          if duplicate found, and charAt(left) is removed and left increased until
          the the character after duplicate is reached
        */
        int longest = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);

            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            longest = Math.max(longest,right-left+1);
        }
        return longest;
    }
}


public class LongestSubStringUniqueChars {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "pwwkew";  // test case

        int result = sol.lengthOfLongestSubstring(s);

        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
