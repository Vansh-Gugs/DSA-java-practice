import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int total = 0;
        HashSet<Integer> set = new HashSet<>();
        int i=0;
        int[] C = new int[A.length];
        while(i<A.length){
            if(!set.contains(A[i])){
                set.add(A[i]);
            }
            else{
                total++;
            }
            if(!set.contains(B[i])){
                set.add(B[i]);
            }
            else{
                total++;
            }
            C[i] = total;
            i++;
        }
        return C;
    }
}
public class prefixCommonArray {
    // Helper to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};

        int[] result = sol.findThePrefixCommonArray(A, B);

        System.out.print("Prefix Common Array: ");
        printArray(result);
    }
}
