class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int mul = 1;
        while (temp > 0) {
            int rem = temp % 10;
            sum += rem;
            mul *= rem;
            temp /= 10;

        }
        return n % (sum + mul) == 0;
    }
}