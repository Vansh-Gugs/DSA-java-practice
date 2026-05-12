import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }
     
    public void push(int x) {
        int size = q.size();
        q.add(x);
        for(int i=1;i<=size;i++){
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}


public class stackUsingQueue {
    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);

        System.out.println("Top element: " + stack.top());

        System.out.println("Popped element: " + stack.pop());

        System.out.println("Is stack empty? " + stack.empty());
    }
}
