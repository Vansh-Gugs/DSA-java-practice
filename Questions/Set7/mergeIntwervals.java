import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        int r = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> result = new ArrayList<>();
        for (int[] interval : intervals) {
            // if empty or no overlapping
            if (result.isEmpty() || result.get(result.size() - 1).get(1) < interval[0]) {
                result.add(Arrays.asList(interval[0], interval[1]));
            } else { //Overlapping
                int last = result.size() - 1;
                int maxEnd = Math.max(result.get(last).get(1), interval[1]);
                result.get(last).set(1, maxEnd);
            }
        }
        int[][] ans = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
        }

        return ans;
    }
}
public class mergeIntwervals {
     // Helper to print 2D array
    public static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        System.out.println("Original Intervals:");
        printIntervals(intervals);

        int[][] result = sol.merge(intervals);

        System.out.println("\nMerged Intervals:");
        printIntervals(result);
    }
}
