
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        long ans = 0;
        int mid = size / 2;

        for (int i = 0; i < mid; i++) {
            ans -= nums[i];
        }for (int i = mid; i < size; i++) {
            ans += nums[i];
        }

        return ans;
    }
}