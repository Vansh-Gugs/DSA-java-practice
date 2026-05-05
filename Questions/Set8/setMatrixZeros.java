import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        //Good solution but not the best, this one take O(m+n) space complexity
        // int r = matrix.length;
        // int c = matrix[0].length;
        // Set<Integer> setRows = new HashSet<>();
        // Set<Integer> setCols = new HashSet<>();
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         if(matrix[i][j]==0){
        //             setRows.add(i);
        //             setCols.add(j);
        //         }
        //     }
        // }
        // for(int i : setRows){
        //     for(int k=0;k<c;k++){
        //         matrix[i][k] = 0;
        //     }
        // }
        // for(int j : setCols){
        //     for(int k=0;k<r;k++){
        //         matrix[k][j] = 0;
        //     }
        // }


        //Optimal Solution O(1) space complexity
        int r = matrix.length;
        int c = matrix[0].length;
        boolean firstColZero = false;
        boolean firstRowZero = false;
        for(int i=0;i<r;i++){
            if(matrix[i][0]==0){
                firstColZero = true;
                break;
            }
        }
        for(int j=0;j<c;j++){
            if(matrix[0][j]==0){
                firstRowZero = true;
                break;
            }
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1;i<r;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<c;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=1;j<c;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<r;i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstColZero==true){
            for(int i=0;i<r;i++) matrix[i][0] = 0; 
        }
        if(firstRowZero==true){
            for(int j=0;j<c;j++) matrix[0][j] = 0;
        }
    }
}

public class setMatrixZeros {
    // Helper to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        sol.setZeroes(matrix);

        System.out.println("\nMatrix after setZeroes:");
        printMatrix(matrix);
    }
}
