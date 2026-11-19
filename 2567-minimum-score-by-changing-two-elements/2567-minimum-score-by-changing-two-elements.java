import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        if (len <= 3) {
            return 0;
        }
        int dropSmallestTwo = arr[len - 1] - arr[2];
        int dropLargestTwo = arr[len - 3] - arr[0];
        int dropBothEnds = arr[len - 2] - arr[1];
        return Math.min(dropSmallestTwo, Math.min(dropLargestTwo, dropBothEnds));
    }
}