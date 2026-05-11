import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] separateDigits(int[] nums) {

        // String method

        // StringBuilder sb = new StringBuilder();
        // for(int num : nums){
        //     sb.append(String.valueOf(num));
        // }
        // int[] result = new int[sb.length()];
        // for(int i=0;i<sb.length();i++){
        //     result[i] = sb.charAt(i) - '0';
        // }
        // return result;

        // Math method
        List<Integer> list = new ArrayList<>(); //to store final values
        for(int num : nums){
            List<Integer> temp = new ArrayList<>(); //to store digits of current num
            while(num>0){
                temp.add(num%10);
                num = num/10;
            }
            // as temp has the digits in reverse order, we need to start from back
            for(int i=temp.size()-1;i>=0;i--){
                list.add(temp.get(i));
            }
        }

        // return type is int[] so need to save all of it in integer array
        int result[] = new int[list.size()];
        for(int i=0;i<result.length;i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
public class SeparateDigitsArray {
    // Helper to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {13, 25, 83, 77};

        int[] result = sol.separateDigits(nums);

        System.out.print("Separated Digits: ");
        printArray(result);
    }
}
