import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> streak = new HashMap<>();
        int best = 0;

        for (int val : nums) {
            int incLen = streak.getOrDefault(val, 0) + 1;
            streak.put(val + 1, incLen);
            best = Math.max(best, incLen);

            int keepLen = streak.getOrDefault(val - 1, 0) + 1;
            streak.put(val, keepLen);
            best = Math.max(best, keepLen);
        }

        return best;
    }
}