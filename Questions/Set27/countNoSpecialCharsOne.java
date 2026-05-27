class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for(char c : word.toCharArray()){
            if(c == Character.toLowerCase(c)){
                lower[c - 'a'] = true;
            }
            else{
                upper[c - 'A'] = true;
            }
        }
        int count = 0;
        for(int i=0;i<lower.length;i++){
            if(lower[i]==true && upper[i]==true)count++;
        }
        return count;
    }
}
public class countNoSpecialCharsOne {
     public static void main(String[] args) {

        Solution sol = new Solution();

        String word = "aaAbcBC";

        int result = sol.numberOfSpecialChars(word);

        System.out.println("Number of Special Characters: " + result);
    }
}
