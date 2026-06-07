import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        // Brute Force O(n^2), will TLE
        // int n = fruits.length;
        // int max_total = 0;
        // if(n==1) return 1;
        // int total = 0;
        // for(int i=0;i<n;i++){
        //     total = 1;
        //     int j = i+1;
        //     while(j<n && fruits[j]==fruits[i]){
        //         total++;
        //         j++;
        //     }
        //     int second_fruit = -1;
        //     if(j<n) second_fruit = fruits[j];
        //     for(;j<n;j++){
        //         if(fruits[j]==fruits[i] || fruits[j]==second_fruit){
        //             total++;
        //         }
        //         else break;
        //     }
        //     max_total = Math.max(max_total,total);
        // }
        // return max_total;

        // Optimal Sliding Window and HashMap but this is O(2n)
        // int n = fruits.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // // type_of_fruit -> frequency map
        // int left=0,right=0,max_len=0;
        // while(left<n && right<n){
        //     if(!map.containsKey(fruits[right])){
        //         map.put(fruits[right],1);
        //     }
        //     else{
        //         map.put(fruits[right],map.get(fruits[right])+1);
        //     }
        //     while(map.size()>2){
        //         map.put(fruits[left],map.get(fruits[left])-1);
        //         if(map.get(fruits[left])==0) map.remove(fruits[left]);
        //         left++;
        //     }
        //     // we only reach here if size of map is less than or equal to 2
        //     max_len = Math.max(max_len,right-left+1);
        //     right++;
        // }
        // return max_len;

        // O(N)
        int n = fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        // type_of_fruit -> frequency map
        int left=0,right=0,max_len=0;
        while(left<n && right<n){
            if(!map.containsKey(fruits[right])){
                map.put(fruits[right],1);
            }
            else{
                map.put(fruits[right],map.get(fruits[right])+1);
            }
            // dont need to do while here, as we are only updating when size is less than equal to 2, or we dont update only
            if(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0) map.remove(fruits[left]);
                left++;
            }
            if(map.size()<=2){
                max_len = Math.max(max_len,right-left+1);
            }
            right++;
        }
        return max_len;
    }
}

public class fruitBasket {
     public static void main(String[] args) {

        Solution sol = new Solution();

        int[] fruits = {1, 2, 1, 3, 5, 1, 1, 2, 2, 1, 2, 2, 4, 1};

        int result = sol.totalFruit(fruits);

        System.out.println("Maximum Fruits Collected: " + result);
    }
}
