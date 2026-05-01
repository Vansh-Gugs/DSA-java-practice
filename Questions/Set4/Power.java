// Class containing power calculation logic
class Solution {
    
    // Helper method to calculate power using recursion
    public double powerr(double x, long n) {
        // Base case: anything raised to 0 is 1
        if (n == 0) return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) return x;
        
        // If 'n' is even
        if (n % 2 == 0) {
            // Recursive call: square the base and halve the exponent
            return powerr(x * x, n / 2);
        }
        
        // If 'n' is odd
        // Recursive call: multiply base once and reduce exponent by 1
        return x * powerr(x, n - 1);
    }
    
    // Public method to handle negative exponents as well
    public double myPow(double x, int n) {
        long N=n;
        // If 'n' is negative, take reciprocal of positive exponent result
        if (n < 0) {
            return 1.0 / powerr(x, -N);
        }
        // If 'n' is non-negative
        return powerr(x,N);
    }
}
public class Power {
     public static void main(String[] args) {
        Solution sol = new Solution();

        double x = 2.0;
        int n = -2;  // test case

        double result = sol.myPow(x, n);

        System.out.println("Result of " + x + "^" + n + " = " + result);
    }
}
