class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Brute Force O(n)
        // int i=0;
        // int num = 1;
        // while(k>0){
        //     if(i<arr.length && arr[i] == num){
        //         i++;
        //         num++;
        //     }
        //     else{
        //         k--;
        //         if(k==0){
        //             return num;
        //         }
        //         num++;
        //     }
        // }
        // return -1;

        // Optimal O(log n) Binary Search
        // At index i of the array no. of missing nums are arr[i] - (i+1) ; so we can apply binary search
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int missing = arr[mid] - (mid+1);
            if(missing<k){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        // // since number is arr[right] + (k - missing), and missing is arr[right] - right - 1 so arr[right] + k - arr[right] + right + 1 which is = k + right + 1
        return k+right+1;

        // we cant do the below one as if we have [2] or [2,4,7] and k = 1,2.. then we will get right as -1, so that is why we had the derive the formula above which is independent of arr[right] so there will be no out of bound exception
        // int missing = arr[right] - (right+1);
        // return arr[right] + (k-missing);
    }
}

public class KthMissingPositiveNum{

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        int result = sol.findKthPositive(arr, k);

        System.out.println("Kth Missing Positive Number: " + result);
    }
}