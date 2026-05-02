import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length-1;;
        while(n>0 && m>0){
            if(nums1[m-1]>=nums2[n-1]){
                nums1[i] = nums1[m-1];
                m--;
                i--;
            }
            else if(nums2[n-1]>=nums1[m-1]){
                nums1[i] = nums2[n-1];
                n--;
                i--;
            }
        }
        while(n>0){
            nums1[i] = nums2[n-1];
            i--;
            n--;
        }
        while(m>0){
            nums1[i] = nums1[m-1];
            i--;
            m--;
        }
    }
}
public class mergeSortedArrays {
     // Helper to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3, 0, 0, 0};  // size = m + n
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.print("Before merge: ");
        printArray(nums1);

        sol.merge(nums1, m, nums2, n);

        System.out.print("After merge:  ");
        printArray(nums1);
    }
}
