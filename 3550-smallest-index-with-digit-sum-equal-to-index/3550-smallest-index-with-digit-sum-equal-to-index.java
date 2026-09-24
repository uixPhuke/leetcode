class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int sum=0;
            
            int og=nums[i];

            while(og>0){
           int rem = og % 10;
sum += rem;
og = og / 10;
            }
            if(sum==i){
                return i;
            }
        }
        return -1;
    }
}