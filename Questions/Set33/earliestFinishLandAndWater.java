class Solution {

    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < landStartTime.length; i++) {

            for(int j = 0; j < waterStartTime.length; j++) {

                // land -> water
                int landFinish =
                    landStartTime[i] + landDuration[i];

                int total1 =
                    Math.max(waterStartTime[j], landFinish)
                    + waterDuration[j];

                // water -> land
                int waterFinish =
                    waterStartTime[j] + waterDuration[j];

                int total2 =
                    Math.max(landStartTime[i], waterFinish)
                    + landDuration[i];

                ans = Math.min(ans,
                               Math.min(total1, total2));
            }
        }

        return ans;
    }
}
public class earliestFinishLandAndWater {
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
