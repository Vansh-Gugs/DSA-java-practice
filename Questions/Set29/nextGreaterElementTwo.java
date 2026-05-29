import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stk = new Stack<>();
        //not optiamal, O(n^2)
        // if(n==1){
        //     result[0] = -1;
        //     return result;
        // }
        // for(int i=0;i<n;i++){
        //     result[i] = -1;
        //     for(int j=(i+1)%n;j!=i;j=(j+1)%n){
        //         if(nums[j]>nums[i]){
        //             result[i] = nums[j];
        //             break;
        //         }
        //     }
        // }
        // return result;

        //Optimal monotonic stack approach
        // we first insert the elements from the array in the monotonic stack in the same way in which we do for NGE 1, but we dont store their next greater elements in the result, we only create the monotonic stack, so that we can use the apply the circular property with modulo concept
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums[i]){
                stk.pop();
            }
            stk.push(nums[i]);
        }
        // now we do it normally as we have next greater elements in the circular order in the stack
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = stk.peek();
            }
            stk.push(nums[i]);
        }
        return result;
    }
}

public class nextGreaterElementTwo {
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {1, 2, 1};

        int[] result = sol.nextGreaterElements(nums);

        System.out.print("Next Greater Elements: ");
        printArray(result);
    }
}
