class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0, evenCount = 1; // evenCount starts at 1 for prefix sum 0 (which is even)
        long currentSum = 0;
        long totalOddSubarrays = 0;
        int mod = 1_000_000_007;

        for (int num : arr) {
            currentSum += num;
            
            if (currentSum % 2 == 1) {
                totalOddSubarrays = (totalOddSubarrays + evenCount) % mod;
                oddCount++;
            } else {
                totalOddSubarrays = (totalOddSubarrays + oddCount) % mod;
                evenCount++;
            }
        }

        return (int) totalOddSubarrays;
    }
}