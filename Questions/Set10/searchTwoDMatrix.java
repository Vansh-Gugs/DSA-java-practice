class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m-1;
        int mid_vert = 0;
        while(top<=bottom){
            mid_vert = top + (bottom-top)/2;
            if(matrix[mid_vert][0] <= target && target <= matrix[mid_vert][n-1]){
                break;
            }
            else if(target<matrix[mid_vert][0]){
                bottom = mid_vert-1;
            }
            else if(target>matrix[mid_vert][0]){
                top = mid_vert+1;
            }
        }

        if(top > bottom) return false;

        int left = 0,right = n-1;
        while(left<=right){
            int mid_horiz = left + (right-left)/2;
            if(matrix[mid_vert][mid_horiz]==target){
                return true;
            }
            if(matrix[mid_vert][mid_horiz]<target){
                left = mid_horiz+1;
            }
            else if(matrix[mid_vert][mid_horiz]>target){
                right = mid_horiz-1;
            }
        }
        return false;
    }
}
public class searchTwoDMatrix {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 3;

        boolean result = sol.searchMatrix(matrix, target);

        System.out.println("Target found: " + result);
    }
}
