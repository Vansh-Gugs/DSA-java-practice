public class removeDuplicates {
    public static boolean[] map = new boolean[26]; //size 26 because there are 26 alphabets

    public static void remDups(String str,int index, String newString){  //can directly access map as it is global

        //base case
        if(index==str.length()){
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(index);
        if(map[currChar-'a'] == true){ //currChar - 'a' gives integer value (a-a = 0, b-a = 1, c-a = 2,.., z-a = 25)
            remDups(str, index+1, newString);
        }
        else{ //if it is not true in the map means it has not already occurred
            newString += currChar;
            map[currChar-'a'] = true;
            remDups(str, index+1, newString);
        }
    }
    public static void main(String[] args) {
        String str = "vaannsshhhvvgg";
        remDups(str, 0,"");
    }
}
