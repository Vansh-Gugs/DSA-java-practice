class Solution {
    public long findHours(int[] piles, int k){//k is number of bananas to eat in an hour
        long totalHours = 0;
        for(int i=0;i<piles.length;i++){
            long curr_hours = (long)Math.ceil((double) piles[i]/k);
            totalHours += curr_hours;
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int num : piles){
            max = Math.max(max,num);
        }
        int left=1,right=max;
        while(left<=right){
            int mid = left + (right-left)/2;
            long hours_taken = findHours(piles,mid);
            if(hours_taken<=h) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}

public class kokoEatingBanans{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int result = sol.minEatingSpeed(piles, h);

        System.out.println("Minimum Eating Speed: " + result);
    }
}