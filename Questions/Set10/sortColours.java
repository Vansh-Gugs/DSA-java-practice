import java.util.Arrays;

class Solution {
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        //Good solution, but can be also done in one pass
        // int count0=0,count1=0,count2=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0) count0++;
        //     else if(nums[i]==1) count1++;
        //     else count2++;
        // }
        // for(int i=0;i<nums.length;i++){
        //     if(count0!=0){
        //         nums[i] = 0;
        //         count0--;
        //     }
        //     else if(count1!=0){
        //         nums[i] = 1;
        //         count1--;
        //     }
        //     else{
        //         nums[i]=2;
        //         count2--;
        //     }
        // }

        //Optimal Solution - Dutch National Flag Algorithm
        // 0 to low-1 is 0s
        // low to mid-1 is 1s
        //mid to high is unsorted
        //high+1 to n-1 is 2s
        int n = nums.length;
        int low=0,mid=0,high=n-1;
        for(int i=0;i<nums.length;i++){

            if(nums[mid]==0){
                swap(nums,low,mid);
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }

        }

    }
}
public class sortColours {
     public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.print("Before sorting: ");
        printArray(nums);

        sol.sortColors(nums);

        System.out.print("After sorting:  ");
        printArray(nums);
    }
}
