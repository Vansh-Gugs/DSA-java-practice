public class fst_last_occur_string {
    public static int first = -1;
    public static int last = -1;
    public static void occurance(String str,int index,char element){
        if(index == str.length()){
            System.out.println(first);
            System.out.println(last);
            first = -1;
            last = -1;
            return;
        }
        char CurrChar = str.charAt(index);
        if(CurrChar == element){
            if(first==-1){
                first = index;
                last = index;
            }
            else{
                last = index;
            }
        }
        occurance(str, index+1, element);
    }


    public static void main(String[] args) {
        String str = "kbhabwlnalwlawbalwv";
        occurance(str, 0, 'a');
        occurance(str, 0, 'k');
    }
}
