class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] minCost = new long[n + 1];
        java.util.Arrays.fill(minCost, Long.MAX_VALUE);
        minCost[0] = 0;

        for (int currentStep = 1; currentStep <= n; currentStep++) {
            for (int prevStep = Math.max(0, currentStep - 3); prevStep < currentStep; prevStep++) {
                if (minCost[prevStep] != Long.MAX_VALUE) {
                    long transitionCost = costs[currentStep - 1] + (long) (currentStep - prevStep) * (currentStep - prevStep);
                    minCost[currentStep] = Math.min(minCost[currentStep], minCost[prevStep] + transitionCost);
                }
            }
        }

        return (int) minCost[n];
    }
}