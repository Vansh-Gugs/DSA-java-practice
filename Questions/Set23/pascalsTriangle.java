import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        for(int i=1;i<numRows;i++){
            List<Integer> curr = new ArrayList<>();;
            List<Integer> prev = result.get(i-1);
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i) curr.add(1); // first and last row always 1
                else{
                    int sum = prev.get(j-1) + prev.get(j);
                    curr.add(sum);
                }
            }
            result.add(curr);
        }
        return result;
    }
}
public class pascalsTriangle {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int numRows = 5;

        List<List<Integer>> result = sol.generate(numRows);

        System.out.println("Pascal's Triangle:");

        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
