class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]) return nums1[i];
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        return -1;
    }
}

public class minCommonVal {
     public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};

        int result = sol.getCommon(nums1, nums2);

        System.out.println("Minimum Common Value: " + result);
    }
}
