class Solution {
    public int addDigits(int num) {
        // Sumulation, O(n) solution
        // while(num>=10){
        //     int new_num = 0;
        //     while(num>0){
        //         int digit = num%10;
        //         new_num = new_num + digit;
        //         num = num/10;
        //     }
        //     num = new_num;
        // }
        // return num;

        // Math O(1) solution
        if(num==0) return 0;
        return 1 + (num-1)%9;
    }
}

public class addDigits {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int num = 38;

        int result = sol.addDigits(num);

        System.out.println("Single Digit Result: " + result);
    }
}
