import java.util.Arrays;

class Solution {

    public int solve(int[] startA,
                     int[] durA,
                     int[] startB,
                     int[] durB) {

        int m = startB.length;

        int[][] rides = new int[m][2];

        for(int i = 0; i < m; i++) {
            rides[i][0] = startB[i];
            rides[i][1] = durB[i];
        }

        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        // prefix minimum duration
        int[] prefixMinDur = new int[m];

        prefixMinDur[0] = rides[0][1];

        for(int i = 1; i < m; i++) {
            prefixMinDur[i] =
                Math.min(prefixMinDur[i - 1],
                         rides[i][1]);
        }

        // suffix minimum (start + duration)
        int[] suffixMinFinish = new int[m];

        suffixMinFinish[m - 1] =
            rides[m - 1][0] + rides[m - 1][1];

        for(int i = m - 2; i >= 0; i--) {

            suffixMinFinish[i] =
                Math.min(suffixMinFinish[i + 1],
                         rides[i][0] + rides[i][1]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < startA.length; i++) {

            int finish =
                startA[i] + durA[i];

            // binary search:
            // first ride with start >= finish
            int l = 0;
            int r = m - 1;
            int pos = m;

            while(l <= r) {

                int mid = l + (r - l) / 2;

                if(rides[mid][0] >= finish) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            // left side:
            // start < finish
            if(pos > 0) {

                ans = Math.min(ans,
                               finish +
                               prefixMinDur[pos - 1]);
            }

            // right side:
            // start >= finish
            if(pos < m) {

                ans = Math.min(ans,
                               suffixMinFinish[pos]);
            }
        }

        return ans;
    }

    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration) {

        int ans1 =
            solve(landStartTime,
                  landDuration,
                  waterStartTime,
                  waterDuration);

        int ans2 =
            solve(waterStartTime,
                  waterDuration,
                  landStartTime,
                  landDuration);

        return Math.min(ans1, ans2);
    }
}

public class earliestFinishLandAndWater{
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};

        int[] waterStartTime = {6};
        int[] waterDuration = {3};

        int result = sol.earliestFinishTime(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration
        );

        System.out.println("Earliest Finish Time: " + result);
    }
}