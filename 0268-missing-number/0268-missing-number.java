class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total_sum=n*(n+1)/2;
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        return total_sum-sum;

    }
}