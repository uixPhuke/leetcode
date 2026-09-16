class Solution {
    public boolean isPalindrome(String s) {

        String ans = s
                .toLowerCase()
                .replaceAll("[^a-z0-9]", "");

        String reverse = new StringBuilder(ans).reverse().toString();

        return ans.equals(reverse);
    }
}