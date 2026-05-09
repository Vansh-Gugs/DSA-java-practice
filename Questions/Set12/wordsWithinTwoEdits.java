import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        int length = queries[0].length();
        for(int i=0;i<queries.length;i++){
            String str_q = queries[i];
            for(int j=0;j<dictionary.length;j++){
                int edit_count = 2;
                String str_d = dictionary[j];
                for(int k=0;k<length;k++){
                    if(str_q.charAt(k)!=str_d.charAt(k)){
                        edit_count--;
                        if(edit_count<0) break;
                    }
                }
                if(edit_count>=0){
                    list.add(str_q);
                    break;
                }
            }
        }
        return list;
    }
}
public class wordsWithinTwoEdits {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] queries = {"word", "note", "ants", "wood"};
        String[] dictionary = {"wood", "joke", "moat"};

        List<String> result = sol.twoEditWords(queries, dictionary);

        System.out.println("Words within two edits:");
        System.out.println(result);
    }
}
