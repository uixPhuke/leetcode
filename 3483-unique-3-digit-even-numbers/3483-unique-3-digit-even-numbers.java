class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;

        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }
        for (int num = 100; num <= 999; num++) {

           
            if (num % 2 != 0) {
                continue;
            }

            int n = num;
            int[] needed = new int[10];

            while (n > 0) {
                needed[n % 10]++;
                n /= 10;
            }

            boolean possible = true;

            for (int d = 0; d <= 9; d++) {
                if (needed[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}