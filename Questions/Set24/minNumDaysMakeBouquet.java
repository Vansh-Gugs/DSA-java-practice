class Solution {

    public int make_bouquets(int[] bloomDay,int day,int k){
        int count = 0;
        int bouquets = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
                if(count==k){
                    count = 0;
                    bouquets = bouquets+1;
                }
            }
            else{
                count=0;
            }
        }
        return bouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(bloomDay.length < (long) m*k) return -1;
        int maxDay = 0;
        int minDay = Integer.MAX_VALUE;
        for(int num : bloomDay){
            maxDay = Math.max(maxDay,num);
            minDay = Math.min(minDay,num);
        }
        int left = minDay,right = maxDay;
        while(left<=right){
            int mid = left + (right-left)/2;
            int bouquets_made = make_bouquets(bloomDay,mid,k);
            if(bouquets_made >= m) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}

public class minNumDaysMakeBouquet {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        int result = sol.minDays(bloomDay, m, k);

        System.out.println("Minimum Days Required: " + result);
    }
}
