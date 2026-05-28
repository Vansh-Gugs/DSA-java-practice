import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && temperatures[i]>=temperatures[stk.peek()]){
                stk.pop();
            }
            if(stk.isEmpty()){
                result[i] = 0;
            }
            else{
                result[i] = stk.peek()-i;
            }
            stk.push(i);
        }
        return result;
    }
}


public class dailyTemperatures {
    // Helper to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = sol.dailyTemperatures(temperatures);

        System.out.print("Days to Wait: ");
        printArray(result);
    }
}
