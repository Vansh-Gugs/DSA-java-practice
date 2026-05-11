class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                if(five<1) return false;
                five--;
                ten++;
            }
            else if(bills[i]==20){
                if(ten==0){
                    if(five<3) return false;
                    five = five-3;
                }
                else if(ten>=1){
                    ten--;
                    if(five<1) return false;
                    five--;
                }
            }
        }
        return true;
    }
}

public class lemonadeChange {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[] bills = {5, 5, 5, 10, 20};

        boolean result = sol.lemonadeChange(bills);

        System.out.println("Can provide change to all customers: " + result);
    }
}
