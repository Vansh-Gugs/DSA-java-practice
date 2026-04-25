import java.util.*;
public class revStack {

    public static void pushBotm(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBotm(data, s);
        s.push(top);
    }

    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse(s);
        pushBotm(top,s);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        Stack<Integer> copy = new Stack<>();
        copy.addAll(s);
        while(!copy.isEmpty()){
            System.out.println(copy.pop());
        }
        
        reverse(s);
        System.out.println("\nReversed Stack:");
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
