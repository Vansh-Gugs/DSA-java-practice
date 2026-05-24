class Solution {
    public boolean isAnagram(String s, String t) {
        //Since map uses hashing overhead, we can use frequency array
        // if(s.length()!=t.length()) return false;
        // HashMap<Character,Integer> map = new HashMap<>();
        // for(char c : s.toCharArray()){
        //     if(!map.containsKey(c)) map.put(c,1);
        //     else map.put(c,map.get(c)+1);
        // }
        // for(char c : t.toCharArray()){
        //     if(!map.containsKey(c)){
        //         return false;
        //     }
        //     else{
        //         map.put(c,map.get(c)-1);
        //         if(map.get(c)<0){
        //             return false;
        //         }
        //     }
        // }
        // return true;

        //Frequency array approach, but this approach is good for lowercase alphabets, otherwise use map
        if(s.length()!=t.length()) return false;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int x : freq){
            if(x!=0) return false;
        }
        return true;


        //There is a third approach where we can sort both strings and then check character by character if they match or not
    }
}

public class validAnagram {
    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "anagram";
        String t = "nagaram";

        boolean result = sol.isAnagram(s, t);

        System.out.println("Are the strings anagrams? " + result);
    }
}
