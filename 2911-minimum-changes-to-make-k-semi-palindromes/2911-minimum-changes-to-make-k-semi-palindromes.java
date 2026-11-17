import java.util.Arrays;

class Solution {
    private int[][] palindromeCost;
    private int[][] semiPalindromeCost;
    private Integer[][] memo;
    private String s;
    private int n;

    public int minimumChanges(String s, int k) {
        this.s = s;
        this.n = s.length();
        
        palindromeCost = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int cost = (s.charAt(i) == s.charAt(j) ? 0 : 1);
                if (len > 2) {
                    cost += palindromeCost[i + 1][j - 1];
                }
                palindromeCost[i][j] = cost;
            }
        }

        semiPalindromeCost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(semiPalindromeCost[i], 1000000);
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                for (int d = 1; d * d <= len; d++) {
                    if (len % d == 0) {
                        if (d < len) {
                            semiPalindromeCost[i][j] = Math.min(semiPalindromeCost[i][j], getSemiPalindromeCost(i, j, d));
                        }
                        int d2 = len / d;
                        if (d2 < len) {
                            semiPalindromeCost[i][j] = Math.min(semiPalindromeCost[i][j], getSemiPalindromeCost(i, j, d2));
                        }
                    }
                }
            }
        }

        memo = new Integer[n][k + 1];
        return solve(0, k);
    }

    private int getSemiPalindromeCost(int start, int end, int d) {
        int totalChanges = 0;
        for (int offset = 0; offset < d; offset++) {
            int left = start + offset;
            int right = end - (d - 1 - offset);
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    totalChanges++;
                }
                left += d;
                right -= d;
            }
        }
        return totalChanges;
    }

    private int solve(int idx, int remK) {
        if (remK == 1) {
            return semiPalindromeCost[idx][n - 1];
        }
        if (memo[idx][remK] != null) {
            return memo[idx][remK];
        }

        int minCost = 1000000;
        for (int j = idx; j <= n - remK; j++) {
            int currentCost = semiPalindromeCost[idx][j];
            minCost = Math.min(minCost, currentCost + solve(j + 1, remK - 1));
        }

        return memo[idx][remK] = minCost;
    }
}