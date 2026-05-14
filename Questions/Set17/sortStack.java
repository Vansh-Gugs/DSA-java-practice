import java.util.Stack;

class Solution {
    public void insert(Stack<Integer> st, int top){
        if(st.isEmpty() || st.peek()<=top){
            st.push(top);
            return;
        }
        int popped = st.pop();
        insert(st,top);
        st.push(popped);
    }
    public void sortStack(Stack<Integer> st) {
        // code here
        if(!st.isEmpty()){
            int top = st.pop();
            sortStack(st);
            insert(st,top);
        }
        return;
    }
}
public class sortStack {
    public static void printStack(Stack<Integer> st) {
        System.out.println(st);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        Stack<Integer> st = new Stack<>();

        st.push(30);
        st.push(-5);
        st.push(18);
        st.push(14);
        st.push(-3);

        System.out.print("Original Stack: ");
        printStack(st);

        sol.sortStack(st);

        System.out.print("Sorted Stack:   ");
        printStack(st);
    }
}
