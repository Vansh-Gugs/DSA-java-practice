import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for(int asteroid : asteroids){
            if(sum>=asteroid) sum = sum + asteroid;
            else return false;
        }
        return true;
    }
}

public class destroyingAsteroids {
     public static void main(String[] args) {

        Solution sol = new Solution();

        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};

        boolean result = sol.asteroidsDestroyed(mass, asteroids);

        System.out.println("Can destroy all asteroids? " + result);
    }
}
