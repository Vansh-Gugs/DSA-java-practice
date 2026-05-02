import java.util.Arrays;

class Solution {
    public void swap(int[][] arr,int i,int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
    public void reverse(int[][] arr,int i,int left,int right){
        while(left<right){
            int temp = arr[i][left];
            arr[i][left] = arr[i][right];
            arr[i][right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {

        //Brute force with extra O(n^2) space
        // int n = matrix.length;
        // int[][] result = new int[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         result[j][n-i-1] = matrix[i][j];
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         matrix[i][j] = result[i][j];
        //     }
        // }

        //Optimal In place solution

        //First transpose the matrix(keep diagonal fixed and swap others)
        // we do j=i+1 because if we do it for all rows and cols, the same cells will be swapped twice and it would become the same again, so in j=i+1 way only upper triangle gets swapped with bottom triangle once.
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j);
            }
        }
        //Now we need to reverse the rows of this transposed matrix
        for(int i=0;i<n;i++){
            int left=0,right=n-1;
            reverse(matrix,i,left,right);
        }
    }
}
public class rotateMatrixInPlace {
     // Helper to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        sol.rotate(matrix);

        System.out.println("\nRotated Matrix:");
        printMatrix(matrix);
    }
}
