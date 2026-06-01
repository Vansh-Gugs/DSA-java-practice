import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stk = new ArrayDeque<>();
        for(int i=0;i<asteroids.length;i++){
            boolean push_flag = true;
            while(!stk.isEmpty() && stk.peek()>0 && asteroids[i]<0){
                if(Math.abs(stk.peek())>Math.abs(asteroids[i])){
                    push_flag = false;
                    break;
                }
                else if(Math.abs(stk.peek())<Math.abs(asteroids[i])){
                    stk.pop();
                }
                else{
                    stk.pop();
                    push_flag = false;
                    break;
                }
            }
            if(push_flag==true){
                stk.push(asteroids[i]);
            }
        }
        int[] result = new int[stk.size()];
        for(int i=0;i<result.length;i++){
            result[i] = stk.removeLast();
        }
        return result;
    }
}
public class asteroidCollisions {
    // Helper to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] asteroids = {5, 10, -5};

        int[] result = sol.asteroidCollision(asteroids);

        System.out.print("Remaining Asteroids: ");
        printArray(result);
    }
}
