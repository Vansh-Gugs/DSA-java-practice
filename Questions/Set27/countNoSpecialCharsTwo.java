import java.util.Arrays;

class Solution {
    public int numberOfSpecialChars(String word) {
        // Map Approach
        // Map<Character,Integer> map = new HashMap<>();
        // for(int i=0;i<word.length();i++){
        //     char c = word.charAt(i);
        //     if(!map.containsKey(c)){
        //         map.put(c,i); //if not in map then just put first occurence
        //     }
        //     else{
        //         if(c == Character.toUpperCase(c)){ //if upper case
        //             //as we store first occurence of upper case
        //             continue;
        //         }
        //         else{ //if lower case
        //             // as we store last occurence of lower case
        //             map.put(c,i);
        //         }
        //     }
        // }
        // int count = 0;
        // for(char key : map.keySet()){
        //     if(key == Character.toLowerCase(key)){ //if lower case
        //         char upper = Character.toUpperCase(key);
        //         if(map.containsKey(upper) && map.get(key) < map.get(upper)) count ++;
        //     }
        // }
        // return count;

        // Array Approach
        int[] lower = new int[26];
        int[] upper = new int[26];
        Arrays.fill(lower,-1);
        Arrays.fill(upper,-1);
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c == Character.toLowerCase(c)){ // if lower case,just update new index
                lower[c - 'a'] = i;
            }
            else{ //if upper case, only store first index
                if(upper[c-'A']==-1){
                    upper[c-'A'] = i;
                }
            }
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(lower[i]!=-1 && upper[i]!=-1 && lower[i]<upper[i]){
                count++;
            }
        }
        return count;
    }
}
public class countNoSpecialCharsTwo {
     public static void main(String[] args) {

        Solution sol = new Solution();

        String word = "aaAbcBC";

        int result = sol.numberOfSpecialChars(word);

        System.out.println("Number of Special Characters: " + result);
    }
}
