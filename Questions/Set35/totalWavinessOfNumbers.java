class Solution {
    public int currentWaviness(int num){
        String n = String.valueOf(num);
        if(n.length() < 3) return 0;
        int total = 0;
        for(int i=1;i<n.length()-1;i++){
            if(n.charAt(i)-'0' > n.charAt(i-1)-'0' && n.charAt(i)-'0' > n.charAt(i+1)-'0'){
                total++;
            }
            if(n.charAt(i)-'0' < n.charAt(i-1)-'0' && n.charAt(i)-'0' < n.charAt(i+1)-'0'){
                total++;
            }
        }
        return total;
    }
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;
        for(int i=num1;i<=num2;i++){
            waviness += currentWaviness(i);
        }
        return waviness;
    }
}

public class totalWavinessOfNumbers {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int num1 = 100;
        int num2 = 110;

        int result = sol.totalWaviness(num1, num2);

        System.out.println("Total Waviness: " + result);
    }
}
