import java.util.HashSet;

public class uniqsubsqns {
    public static void unique_subsequence(String str,int index,String newString,HashSet<String> set){
        if(index==str.length()){
            if(set.contains(newString)){
                return;
            }
            else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar = str.charAt(index);
        //to be
        unique_subsequence(str, index+1, newString+currChar, set);

        //or not to be
        unique_subsequence(str, index+1, newString, set);
    }
    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        unique_subsequence(str, 0, "", set);
    }
}
