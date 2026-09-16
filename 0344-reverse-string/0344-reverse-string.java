class Solution {
    public void reverseString(char[] s) {
        //StringBuilder str=new StringBuilder();
        int right=s.length-1;
        int left=0;
        for(left=0;left<right;left++){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            right--;
        }
        
    }
}