import java.util.Stack;

class MyQueue {
    Stack<Integer> stk;
    Stack<Integer> helper;
    public MyQueue() {
        stk = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        //For push O(n) and pop peek O(1)
        // while(!stk.isEmpty()){
        //     helper.push(stk.pop());
        // }
        // stk.push(x);
        // while(!helper.isEmpty()){
        //     stk.push(helper.pop());
        // }

        // For push O(1) and pop peek O(n)
        stk.push(x);
    }
    
    public int pop() {
        //For push O(n) and pop peek O(1)
        // return stk.pop();

        // For push O(1) and pop peek O(n)
        if(!helper.isEmpty()){
            return helper.pop();
        }
        else{
            while(!stk.isEmpty()){
                helper.push(stk.pop());
            }
            return helper.pop();
        }
    }
    
    public int peek() {
        //For push O(n) and pop peek O(1)
        // return stk.peek();

        // For push O(1) and pop peek O(n)
        if(!helper.isEmpty()){
            return helper.peek();
        }
        else{
            while(!stk.isEmpty()){
                helper.push(stk.pop());
            }
            return helper.peek();
        }
    }
    
    public boolean empty() {
        //For push O(n) and pop peek O(1)
        // return stk.isEmpty();
        
        // For push O(1) and pop peek O(n)
        return stk.isEmpty() && helper.isEmpty();
    }
}

public class queueUsingStacks {
    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Removed element: " + queue.pop());

        System.out.println("Is queue empty? " + queue.empty());
    }
}
