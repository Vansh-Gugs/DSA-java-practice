public class subsequences {
    public static void subsequence(String str,int index,String newString)
    {
        if(index==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);

        // to be
        subsequence(str, index+1, newString+currChar);

        // or not to be
        subsequence(str, index+1, newString);
    }
    public static void main(String[] args) {
        String str = "abc";
        subsequence(str,0,"");
    }
}
