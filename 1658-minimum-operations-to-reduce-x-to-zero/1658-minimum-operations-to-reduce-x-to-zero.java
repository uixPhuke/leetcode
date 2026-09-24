class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        int target=totalSum-x;
        if(target<0){
            return -1;
        }
        if(target==0){
            return nums.length;
        }
        

        int l=0;
        int maxLength=0;
        int sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>target){
                sum-=nums[l++];
            }
            if(sum==target){
                maxLength=Math.max(maxLength,r-l+1);
            }

        }
        if (maxLength==0){
            return -1;
        }
        return nums.length-maxLength;
    }
}