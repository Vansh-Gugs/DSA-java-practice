import java.util.ArrayList;
import java.util.Stack;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        // Monotonic stack
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stk.isEmpty() && arr[i]<=stk.peek()){
                stk.pop();
            }
            if(stk.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = stk.peek();
            }
            stk.push(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : result){
            list.add(num);
        }
        return list;
    }
}
public class nextSmallerElement {
     public static void main(String[] args) {

        Solution sol = new Solution();

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> result = sol.nextSmallerEle(arr);

        System.out.println("Next Smaller Elements:");
        System.out.println(result);
    }
}
