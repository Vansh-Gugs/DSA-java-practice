class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // int size = flowerbed.length;

        // //If flowers to plant is 0 initially
        // if(n==0) return true;

        // //If size is 1
        // if(size==1 && flowerbed[0]==0){
        //     flowerbed[0] = 1;
        //     n--;
        //     return true;
        // }
        // else if(size==1 && flowerbed[0]==1){
        //     return false;
        // }

        // //For handling 0th index
        // if(flowerbed[0]==0 && flowerbed[1]==0){
        //     flowerbed[0] = 1;
        //     n--;
        // }

        // for(int i=1;i<size;i++){
        //     if(n==0) return true;
        //     if(i<size-1 && flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
        //         flowerbed[i] = 1;
        //         n--;
        //         i++;
        //     }
        //     if(i==size-1 && flowerbed[i]==0 && flowerbed[i-1]==0){
        //         flowerbed[i] = 1;
        //         n--;
        //     }
        // }
        // if(n==0) return true;
        // return false;

        //Above too complex
        int count = 0;
        int size = flowerbed.length;
        for(int i=0;i<size;i++){
            if(flowerbed[i]==0){
                int left=-1;
                int right = -1;
                if(i==0){
                    left = 0;
                }
                else{
                    left = flowerbed[i-1];
                }
                if(i==size-1){
                    right = 0;
                }
                else{
                    right = flowerbed[i+1];
                }

                if(left==0 && right==0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
            if(count>=n) return true;
        }
        return count>=n;
    }
}
public class placingFlowers {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] flowerbed = {1, 0, 0, 0,0,0, 1,0,0,0,1};  // test case
        int n = 3;

        boolean result = sol.canPlaceFlowers(flowerbed, n);

        System.out.println("Can place " + n + " flowers: " + result);
    }
}
