import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        //Monotonic Stack approach
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!stk.isEmpty() && k>0 && (stk.peek() - '0') > (num.charAt(i) - '0')){
                stk.pop();
                k--;
            }
            // push the new number (this will keep pushing even if k is 0)
            stk.push(num.charAt(i));
        }
        //this may happen if the numbers keep coming in increasing order, for example 1 2 3 4 5 6, there will be no popping and k will no decrease, so we need to pop the top k elements
        while(k>0){
            stk.pop();
            k--;
        }
        if(stk.isEmpty()) return "0";
        
        String reversed = "";
        while(!stk.isEmpty()){
            reversed = reversed + stk.pop(); //this will store the number in reverse order, as they are being popped in reverse order from the stack
        }
        int i=reversed.length()-1;
        while(i >= 0 && reversed.charAt(i)=='0'){
            reversed = reversed.substring(0,reversed.length()-1);
            i--;
        }
        if(reversed.length()==0) return "0";
        String result = new StringBuilder(reversed).reverse().toString();
        return result;
    }
}
public class removeKNumbers {
    public static void main(String[] args) {

        Solution sol = new Solution();

        String num = "1432219";
        int k = 3;

        String result = sol.removeKdigits(num, k);

        System.out.println("Smallest Number After Removing Digits: " + result);
    }
}
