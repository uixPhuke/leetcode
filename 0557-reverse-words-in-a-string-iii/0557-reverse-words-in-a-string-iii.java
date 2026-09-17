class Solution {
    public String reverseWords(String s) {
        char[] ans=s.toCharArray();
        int left=0;
        for(int right=0;right<=ans.length;right++){
            if (right == ans.length || ans[right] == ' ') {
                int start=left;
                int end=right-1;
                while(start<end){
                    char temp=ans[start];
                    ans[start]=ans[end];
                    ans[end]=temp;

                    start++;
                    end--;
                }
                left=right+1;

            }

        }
            return new  String(ans);
    
}
}