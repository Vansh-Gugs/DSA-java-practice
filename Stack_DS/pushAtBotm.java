import java.util.*;
public class pushAtBotm {

    public static void pushBotm(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBotm(data, s);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushBotm(4, s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }


        // popping when we have Stack<Integer> ...etc
        // if(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        // System.out.println(s);
    }
}
