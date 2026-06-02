class Solution {
    public int getNext(int num){
        int sum = 0;
        while(num>0){
            int digit = num%10;
            sum = sum + digit*digit;
            num = num/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        // HashSet approach, not optimal, O(n) space
        // HashSet<Integer> set = new HashSet<>();
        // while(true){
        //     int sum = 0;
        //     while(n>0){
        //         int digit = n%10;
        //         sum += digit*digit;
        //         n = n/10;
        //     }
        //     if(sum == 1) return true;
        //     if(!set.contains(sum)) set.add(sum);
        //     else return false;
        //     n = sum;
        // }

        // Floyd Cycle Detection , O(1) Space
        int slow = n;
        int fast = n;
        do{
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
}
public class numIsHappy {
        public static void main(String[] args) {

        Solution sol = new Solution();

        int n = 19;

        boolean result = sol.isHappy(n);

        System.out.println("Is Happy Number? " + result);
    }
}
