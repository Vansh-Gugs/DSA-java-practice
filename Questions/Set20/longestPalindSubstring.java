class Solution {
    int start = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            expand(s,i,i); // for odd palindrome (it has 1 centre)
            expand(s,i,i+1); // for even palindrome (it has 2 centres)
        }
        return s.substring(start,start+maxLen);
    }

    public void expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            if(right-left+1 > maxLen){ //only update start and maxLen if the length of current substring is longer then prev longest substring
                start = left;
                maxLen = right-left+1;
            }
            left--;
            right++;
        }
    }
}
public class longestPalindSubstring {
     public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "babad";

        String result = sol.longestPalindrome(s);

        System.out.println("Longest Palindromic Substring: " + result);
    }
}
