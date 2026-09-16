class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int bestValue=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
        
      
            int profit=prices[i]-min;
            if(profit>bestValue){
                bestValue=profit;
            }

        }
        return bestValue;
    }
}