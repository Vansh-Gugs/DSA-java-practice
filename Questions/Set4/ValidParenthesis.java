import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stk.push(c);
            }
            else if(c==')'){
                if(!stk.isEmpty() && stk.pop()=='(') continue;
                else return false;
            }
            else if(c=='}'){
                if(!stk.isEmpty() && stk.pop()=='{') continue;
                else return false;
            }
            else if(c==']'){
                if(!stk.isEmpty() && stk.pop()=='[') continue;
                else return false;
            }
        }
        if(!stk.isEmpty()){
            return false;
        }
        return true;
    }
}
public class ValidParenthesis {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "()[]{}";  // test case

        boolean result = sol.isValid(s);

        System.out.println("Is valid parentheses: " + result);
    }
}
