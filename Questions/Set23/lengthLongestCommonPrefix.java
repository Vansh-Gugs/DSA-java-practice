import java.util.HashSet;

class Solution {
    //TLE 
    // public int longestPrefix(String s1, String s2){
    //     int pre_len = 0;
    //     String prefix = s1;
    //     while(prefix.length()>0){
    //         if(!s2.startsWith(prefix)){
    //             prefix = prefix.substring(0,prefix.length()-1);
    //         }
    //         else{
    //             return prefix.length();
    //         }
    //     }
    //     return 0;
    // }
    // public int longestCommonPrefix(int[] arr1, int[] arr2) {
    //     int max_len = 0;
    //     for(int i=0;i<arr1.length;i++){
    //         for(int j=0;j<arr2.length;j++){
    //             String str1 = Integer.toString(arr1[i]);
    //             String str2 = Integer.toString(arr2[j]);
    //             int pre_len = longestPrefix(str1,str2);
    //             max_len = Math.max(pre_len,max_len);
    //         }
    //     }
    //     return max_len;
    // }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int num : arr1){
            String str = Integer.toString(num);
            String prefix = "";
            for(char c : str.toCharArray()){
                prefix = prefix + c;
                set.add(prefix);
            }
        }
        int max_len = 0;
        for(int num : arr2){
            String str = Integer.toString(num);
            String prefix = "";
            for(char c : str.toCharArray()){
                prefix = prefix + c;
                if(set.contains(prefix))
                    max_len = Math.max(max_len,prefix.length());
            }
        }
        return max_len;
    }
}
public class lengthLongestCommonPrefix {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};

        int result = sol.longestCommonPrefix(arr1, arr2);

        System.out.println("Longest Common Prefix Length: " + result);
    }
}
