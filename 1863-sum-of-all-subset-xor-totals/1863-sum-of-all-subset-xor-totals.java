class Solution {
    public int subsetXORSum(int[] nums) {
       int total=0;
        for(int result: nums){
            total=total | result;
            
        }
        return total*(int) (Math.pow(2,nums.length-1));

        
        }
    }
