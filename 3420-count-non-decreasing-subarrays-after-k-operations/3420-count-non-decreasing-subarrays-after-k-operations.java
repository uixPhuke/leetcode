import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<long[]> dq = new ArrayDeque<>();
        long ops = 0;
        long ans = 0;
        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            long val = nums[l];
            long cnt = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] < val) {
                long[] front = dq.pollFirst();
                ops += (val - front[0]) * front[1];
                cnt += front[1];
            }
            dq.addFirst(new long[]{val, cnt});

            while (ops > k) {
                long[] back = dq.peekLast();
                ops -= (back[0] - nums[r]);
                if (back[1] == 1) {
                    dq.pollLast();
                } else {
                    back[1]--;
                }
                r--;
            }

            ans += r - l + 1;
        }

        return ans;
    }
}