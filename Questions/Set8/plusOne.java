import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i] = digits[i]+1;
                break;
            }
            else{
                digits[i] = 0;
            }
        }
        if(digits[0] == 0){
            int[] result = new int[digits.length+1]; // makes an array with all default values as 0
            result[0] = 1;
            return result;
        }
        return digits;
    }
}

public class plusOne {
     // Helper to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] digits = {9, 9, 9};  // test case

        System.out.print("Original: ");
        printArray(digits);

        int[] result = sol.plusOne(digits);

        System.out.print("After Plus One: ");
        printArray(result);
    }
}
